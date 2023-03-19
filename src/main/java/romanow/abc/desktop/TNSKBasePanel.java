package romanow.abc.desktop;

public class TNSKBasePanel extends BasePanel{
    TNSKClient main2;
    public TNSKBasePanel() {}
    @Override
    public void refresh() {}
    @Override
    public void eventPanel(int code, int par1, long par2, String par3,Object oo) { }
    @Override
    public void shutDown() {}
    public void initPanel(MainBaseFrame main0){
        super.initPanel(main0);
        main2 = (TNSKClient)main0;
        }
}
