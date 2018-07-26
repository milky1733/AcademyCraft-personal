package cn.academy.vanilla.electromaster.client.effect;

import cn.academy.vanilla.electromaster.client.effect.ArcFactory.Arc;
import cn.lambdalib2.annoreg.core.Registrant;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 *
 */
@Registrant
@SideOnly(Side.CLIENT)
public class ArcPatterns {
    
    static final int GEN = 20;

    public static Arc[] weakArc;
    
    public static Arc[] thinContiniousArc;
    
    public static Arc[] chargingArc;
    
    public static Arc[] strongArc;
    
    public static Arc[] aoeArc;
    
    static {
        {
            ArcFactory fac = new ArcFactory();
            fac.branchFactor = 0.15;
            fac.passes = 6;
            fac.maxOffset = 1.1;
            
            weakArc = fac.generateList(GEN, 20, 20);
        }
        
        {
            ArcFactory fac = new ArcFactory();
            fac.branchFactor = 0.2;
            fac.passes = 5;
            fac.width = 0.08;
            fac.maxOffset = 1.2;
            
            thinContiniousArc = fac.generateList(GEN, 20, 20);
        }
        
        {
            ArcFactory fac = new ArcFactory();
            fac.branchFactor = 0.3;
            fac.passes = 5;
            fac.width = 0.1;
            fac.maxOffset = 1.2;
            
            chargingArc = fac.generateList(GEN, 20, 20);
        }
        
        {
            ArcFactory fac = new ArcFactory();
            fac.branchFactor = 0.3;
            fac.passes = 5;
            fac.width = 0.3;
            fac.maxOffset = 1.4;
            
            strongArc = fac.generateList(GEN, 20, 20);
        }
        
        {
            ArcFactory fac = new ArcFactory();
            fac.branchFactor = 0.28;
            fac.passes = 5;
            fac.width = 0.13;
            fac.maxOffset = 1.2;
            
            aoeArc = fac.generateList(GEN, 20, 20);
        }
    }

}
