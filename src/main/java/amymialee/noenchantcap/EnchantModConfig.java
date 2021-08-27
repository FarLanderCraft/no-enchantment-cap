package amymialee.noenchantcap;

public class EnchantModConfig {
    public final boolean removeAnvilLimit;
    public final boolean allowAnyEnchantOnAnyItem;
    public final boolean useGlobalEnchantCap;
    public final int globalEnchantCap;
    public final int protectionCap;
    public final int protectionFireCap;
    public final int protectionBlastCap;
    public final int protectionProjectileCap;
    public final int respirationCap;
    public final int thornsCap;
    public final int depthStriderCap;
    public final int featherFallingCap;
    public final int smiteCap;
    public final int sharpnessCap;
    public final int baneOfArthropodsCap;
    public final int knockbackCap;
    public final int fireAspectCap;
    public final int lootingCap;
    public final int efficiencyCap;
    public final int fortuneCap;
    public final int powerCap;
    public final int punchCap;
    public final int lureCap;
    public final int luckOfTheSeaCap;
    public final int unbreakingCap;

    public EnchantModConfig(boolean a, boolean c, boolean d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int s, int t, int u, int v, int w, int x, int y, int z, int iRanOut, int ofAlphabet) {
        this.removeAnvilLimit = a; //true
        this.allowAnyEnchantOnAnyItem = c;//false
        this.useGlobalEnchantCap = d;
        this.globalEnchantCap = e;//10
        this.protectionCap = f;//4
        this.protectionFireCap = g;//4
        this.protectionBlastCap = h;//4
        this.protectionProjectileCap = i;//4
        this.respirationCap = j;//3
        this.thornsCap = k;//3
        this.depthStriderCap = m;//3
        this.featherFallingCap = n;//4
        this.smiteCap = o;//5
        this.sharpnessCap = p;//5
        this.baneOfArthropodsCap = q;//5
        this.knockbackCap = r;//2
        this.fireAspectCap = s;//2
        this.lootingCap = t;//3
        this.efficiencyCap = v;//5
        this.fortuneCap = w;//3
        this.powerCap = x;//5
        this.punchCap = y;//2
        this.lureCap = z;//3
        this.luckOfTheSeaCap = iRanOut;//3
        this.unbreakingCap = ofAlphabet;//3
    }
}
