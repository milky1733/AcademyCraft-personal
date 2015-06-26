package cn.academy.ability.api.ctrl;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author EAirPeter
 */
public abstract class SyncAction {

	int id;
	State state;
	int intv = -1;
	int lastInformed = 0;
	
	protected final boolean isRemote = FMLCommonHandler.instance().getEffectiveSide().equals(Side.CLIENT);
	
	/**
	 * The associated player
	 * null for started from server
	 */
	protected EntityPlayer player = null;
	
	/**
	 * Construct a SyncAction
	 * Notice: Every subclass of SyncAction must have a constructor with no parameter
	 * @param interval Server side will send an update to client side every interval ticks, while -1 for never.
	 */
	protected SyncAction(int interval) {
		intv = interval;
		state = State.CREATED;
	}
	
	static enum State {
		CREATED,
		IDENTIFIED,
		STARTED,
		ENDED,
		ABORTED
	}
	
	/* start from client
	 * send to server(start)
	 * server reply, server.onStart or nothing
	 * corresponding: client.onStart or nothing
	 */
	/* start from server
	 * send to client(start), server.onStart
	 * client.onStart or abortAtServer
	 */
	/**
	 * Called when this start at both sides
	 */
	public void onStart() {
	}
	
	/* (server) tick and send(every ${interval})
	 * server inform
	 */
	/**
	 * Called every tick at both sides
	 */
	public void onTick() {
	}
	
	
	/* end from client
	 * send to server
	 * server reply, server inform(final) and (server.onAbort or server.onEnd) 
	 * client.onUpdate and (corresponding: client.onAbort or client.onEnd) 
	 */
	/* end from server
	 * send to client, server inform(final) and server.onEnd
	 * client.onUpdate and client.onEnd
	 */
	/**
	 * Called when ended at both sides
	 */
	public void onEnd() {
	}
	
	/* abort from client
	 * send to server
	 * server inform(final) and server.onAbort
	 * client.onUpdate and client.onAbort
	 */
	/* abort from server
	 * server inform(final) and server.onAbort
	 * client.onUpdate and client.onAbort
	 */
	/**
	 * Called when aborted at both sides
	 * This is nothing to do with network
	 * If any, please use NBT operation(Final)
	 */
	public void onAbort() {
	}
	
	public void readNBTStart(NBTTagCompound tag) {
	}
	public void readNBTUpdate(NBTTagCompound tag) {
	}
	public void readNBTFinal(NBTTagCompound tag) {
	}
	public void writeNBTStart(NBTTagCompound tag) {
	}
	public void writeNBTUpdate(NBTTagCompound tag) {
	}
	public void writeNBTFinal(NBTTagCompound tag) {
	}
	
	private static final String NBT_ID = "0";
	private static final String NBT_STATE = "1";
	private static final String NBT_INTERVAL = "2";
	private static final String NBT_OBJECT = "3";
	
	void setNBTStart(NBTTagCompound tag) {
		id = tag.getInteger(NBT_ID);
		intv = tag.getInteger(NBT_INTERVAL);
		if (tag.hasKey(NBT_OBJECT))
			readNBTStart(tag.getCompoundTag(NBT_OBJECT));
	}
	void setNBTUpdate(NBTTagCompound tag) {
		if (tag.hasKey(NBT_OBJECT))
			readNBTUpdate(tag.getCompoundTag(NBT_OBJECT));
	}
	void setNBTFinal(NBTTagCompound tag) {
		state = State.valueOf(tag.getString(NBT_STATE));
		if (tag.hasKey(NBT_OBJECT))
			readNBTFinal(tag.getCompoundTag(NBT_OBJECT));
	}
	NBTTagCompound getNBTStart() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger(NBT_ID, id);
		tag.setInteger(NBT_INTERVAL, intv);
		NBTTagCompound obj = new NBTTagCompound();
		writeNBTStart(obj);
		tag.setTag(NBT_OBJECT, obj);
		return tag;
	}
	NBTTagCompound getNBTUpdate() {
		NBTTagCompound tag = new NBTTagCompound();
		NBTTagCompound obj = new NBTTagCompound();
		writeNBTUpdate(obj);
		tag.setTag(NBT_OBJECT, obj);
		return tag;
	}
	NBTTagCompound getNBTFinal() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString(NBT_STATE, state.toString());
		NBTTagCompound obj = new NBTTagCompound();
		writeNBTFinal(obj);
		tag.setTag(NBT_OBJECT, obj);
		return tag;
	}
	
	static final int getIdFromNBT(NBTTagCompound tag) {
		if (tag.hasKey(NBT_ID))
			return tag.getInteger(NBT_ID);
		else
			return -1;
	}
	
	static final NBTTagCompound TAG_ENDED;
	static final NBTTagCompound TAG_ABORTED;
	
	static {
		TAG_ENDED = new NBTTagCompound();
		TAG_ENDED.setString(NBT_STATE, State.ENDED.toString());
		TAG_ABORTED = new NBTTagCompound();
		TAG_ABORTED.setString(NBT_STATE, State.ABORTED.toString());
	}
	
}