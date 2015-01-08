/**
 * 
 */
package cn.academy.core.block.dev;

import cn.academy.api.data.AbilityData;
import cn.academy.core.client.ACLangs;

/**
 * The level-up action. Handles level upgrading.
 * @author WeathFolD
 *
 */
public class DevActionLevel implements IDevAction {
	
	final int toLevel;

	public DevActionLevel(int level) {
		toLevel = level;
	}

	@Override
	public int getExpectedStims(AbilityData data) {
		return 10;
	}

	@Override
	public void onActionFinished(AbilityData data) {
		data.setLevelID(toLevel);
	}

	@Override
	public String getActionInfo(AbilityData data) {
		return ACLangs.upgradeTo() + data.getCategory().getLevel(data.getLevelID() + 1).getDisplayName();
	}

	@Override
	public double getSuccessfulRate(AbilityData data) {
		return data.getLevel().getStimulationProb();
	}
	
}
