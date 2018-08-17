package cn.academy.client.render.block;

import cn.academy.Resources;
import cn.academy.block.tileentity.TileWindGenBase;
import cn.lambdalib2.multiblock.RenderBlockMultiModel;
import cn.lambdalib2.util.deprecated.TileEntityModelCustom;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * @author WeAthFolD
 */
public class RenderWindGenBase extends RenderBlockMultiModel {
    
    private ResourceLocation
        TEX_NORMAL = Resources.getTexture("models/windgen_base"),
        TEX_DISABLED = Resources.getTexture("models/windgen_base_disabled");

    public RenderWindGenBase() {
        super(new TileEntityModelCustom(Resources.getModel("windgen_base")),
                null);
    }
    
    @Override
    public void drawAtOrigin(TileEntity te) {
        TileWindGenBase tile = (TileWindGenBase) te;
        this.tex = tile.isComplete() ? TEX_NORMAL : TEX_DISABLED;
        super.drawAtOrigin(te);
    }
    
}