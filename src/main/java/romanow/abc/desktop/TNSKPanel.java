/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package romanow.abc.desktop;

import retrofit2.Call;
import romanow.abc.core.DBRequest;
import romanow.abc.core.ErrorList;
import romanow.abc.core.UniException;
import romanow.abc.core.constants.ConstValue;
import romanow.abc.core.constants.Values;
import romanow.abc.core.constants.ValuesBase;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.baseentityes.JBoolean;
import romanow.abc.core.entity.server.TCare;
import romanow.abc.core.entity.server.TCarePoint;
import romanow.abc.core.entity.server.TSegmentStatistic;
import romanow.abc.core.entity.subjectarea.TRoute;
import romanow.abc.core.entity.subjectarea.TRouteStop;
import romanow.abc.core.entity.subjectarea.TSegment;
import romanow.abc.core.prepare.DayCellList;
import romanow.abc.core.prepare.WeekCellList;
import romanow.abc.core.utils.GPSPoint;

import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class TNSKPanel extends TNSKBasePanel {
    private EntityRefList<TRoute> routes = new EntityRefList<>();
    private TRoute cRoute = null;
    private HashMap<Integer, ConstValue> typeMap = new HashMap<>();
    private EntityRefList<TSegment> roads = new EntityRefList<>();
    private EntityRefList<TCare> cares = new EntityRefList<>();
    private EntityRefList<TSegment> segments = new EntityRefList<>();
    private boolean scanOn=false;
    /**
     * Creates new form TNSKPanel
     */
    public TNSKPanel() {
        initComponents();
    }
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public void initPanel(MainBaseFrame main0) {
        super.initPanel(main0);
        Busy.setVisible(false);
        typeMap = Values.constMap().getGroupMapByValue("RouteType");
        testScanState();
        if (scanOn){
            refreahRoutes();
            refreshSegments();
            }
        }
    private boolean testBusy(){
        if (!Busy.isVisible())
            return false;
        main.popup("Выполнение операции в фоне");
        return true;
        }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScanOnOff = new javax.swing.JButton();
        GorTransImport = new javax.swing.JButton();
        Busy = new javax.swing.JButton();
        RouteList = new java.awt.Choice();
        StopList = new java.awt.Choice();
        Distance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        GPSY = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        RouteCares = new javax.swing.JButton();
        CaresList = new java.awt.Choice();
        NearestCares = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        GPSX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CarePoints = new java.awt.Choice();
        jLabel8 = new javax.swing.JLabel();
        StorySize = new javax.swing.JTextField();
        Segments = new java.awt.Choice();
        jLabel9 = new javax.swing.JLabel();
        SegmentTotalCount = new javax.swing.JTextField();
        SegmentNotNull = new javax.swing.JTextField();

        setLayout(null);

        ScanOnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/status_gray.png"))); // NOI18N
        ScanOnOff.setBorderPainted(false);
        ScanOnOff.setContentAreaFilled(false);
        ScanOnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanOnOffActionPerformed(evt);
            }
        });
        add(ScanOnOff);
        ScanOnOff.setBounds(105, 10, 40, 40);

        GorTransImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/download.png"))); // NOI18N
        GorTransImport.setBorderPainted(false);
        GorTransImport.setContentAreaFilled(false);
        GorTransImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GorTransImportActionPerformed(evt);
            }
        });
        add(GorTransImport);
        GorTransImport.setBounds(75, 15, 30, 30);

        Busy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/shiftoff1.png"))); // NOI18N
        Busy.setBorderPainted(false);
        Busy.setContentAreaFilled(false);
        add(Busy);
        Busy.setBounds(20, 10, 40, 40);

        RouteList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RouteListItemStateChanged(evt);
            }
        });
        add(RouteList);
        RouteList.setBounds(120, 60, 370, 20);
        add(StopList);
        StopList.setBounds(120, 90, 370, 20);

        Distance.setText("1000");
        add(Distance);
        Distance.setBounds(110, 240, 71, 25);

        jLabel1.setText("Сегменты");
        add(jLabel1);
        jLabel1.setBounds(20, 280, 90, 16);

        GPSY.setText("54.888938");
        add(GPSY);
        GPSY.setBounds(110, 180, 90, 25);

        jLabel2.setText("Ближайшие");
        add(jLabel2);
        jLabel2.setBounds(220, 180, 140, 16);

        RouteCares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/taxi.png"))); // NOI18N
        RouteCares.setBorderPainted(false);
        RouteCares.setContentAreaFilled(false);
        RouteCares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RouteCaresActionPerformed(evt);
            }
        });
        add(RouteCares);
        RouteCares.setBounds(490, 50, 50, 40);

        CaresList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CaresListItemStateChanged(evt);
            }
        });
        add(CaresList);
        CaresList.setBounds(120, 120, 510, 20);

        NearestCares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/taxi.png"))); // NOI18N
        NearestCares.setBorderPainted(false);
        NearestCares.setContentAreaFilled(false);
        NearestCares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NearestCaresActionPerformed(evt);
            }
        });
        add(NearestCares);
        NearestCares.setBounds(210, 200, 50, 40);

        jLabel3.setText("Долгота");
        add(jLabel3);
        jLabel3.setBounds(20, 210, 90, 16);

        GPSX.setText("83.095822");
        add(GPSX);
        GPSX.setBounds(110, 210, 90, 25);

        jLabel4.setText("История");
        add(jLabel4);
        jLabel4.setBounds(20, 150, 90, 16);

        jLabel5.setText("Маршруты");
        add(jLabel5);
        jLabel5.setBounds(20, 60, 100, 16);

        jLabel6.setText("Остановки");
        add(jLabel6);
        jLabel6.setBounds(20, 90, 100, 16);

        jLabel7.setText("Борта");
        add(jLabel7);
        jLabel7.setBounds(20, 120, 100, 16);
        add(CarePoints);
        CarePoints.setBounds(120, 150, 510, 20);

        jLabel8.setText("Широта");
        add(jLabel8);
        jLabel8.setBounds(20, 180, 50, 16);

        StorySize.setEnabled(false);
        add(StorySize);
        StorySize.setBounds(640, 140, 40, 25);

        Segments.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SegmentsItemStateChanged(evt);
            }
        });
        add(Segments);
        Segments.setBounds(110, 280, 520, 20);

        jLabel9.setText("Дистанция (м)");
        add(jLabel9);
        jLabel9.setBounds(20, 240, 90, 16);

        SegmentTotalCount.setEnabled(false);
        add(SegmentTotalCount);
        SegmentTotalCount.setBounds(690, 275, 60, 25);

        SegmentNotNull.setEnabled(false);
        add(SegmentNotNull);
        SegmentNotNull.setBounds(640, 275, 40, 25);
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void refresh() {
        }
    @Override
    public void eventPanel(int code, int par1, long par2, String par3, Object oo) {
        }
    @Override
    public void shutDown() {
        }

    private void testScanState(){
        new APICall<JBoolean>(main){
            @Override
            public Call<JBoolean> apiFun() {
                return main2.service2.getScanState(main2.debugToken);
                }
            @Override
            public void onSucess(JBoolean oo) {
                scanOn = oo.value();
                if (oo.value())
                    ScanOnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/status_green.png")));
                else
                    ScanOnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/status_gray.png")));
                }
            };
        }
    private void ScanOnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanOnOffActionPerformed
        if (testBusy())
            return;
        new APICallAsync<ErrorList>(Busy,main){
            @Override
            public Call<ErrorList> apiFun() {
                return main2.service2.changeScanState(main2.debugToken, main.loginUser.getAccount().getPassword());
                }
            @Override
            public void onSucess(ErrorList oo) {
                System.out.println(oo.toString());
                testScanState();
                if (scanOn){
                    refreahRoutes();
                    refreshSegments();
                    }
            }
        };
    }//GEN-LAST:event_ScanOnOffActionPerformed

    private void GorTransImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GorTransImportActionPerformed
        if (testBusy())
            return;
        new OK(200, 200, "Импортировать ДС с NskGorTrans", new I_Button() {
            @Override
            public void onPush() {
                new APICallAsync<ErrorList>(Busy,main) {
                    @Override
                    public Call<ErrorList> apiFun() {
                        return ((TNSKClient)main).service2.gorTransImport(main.debugToken, main.loginUser.getAccount().getPassword());
                    }
                    @Override
                    public void onSucess(ErrorList oo) {
                        System.out.println(oo);
                    }
                };
            }
        });
    }//GEN-LAST:event_GorTransImportActionPerformed

    private void RouteListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RouteListItemStateChanged
        refreshStops();
    }//GEN-LAST:event_RouteListItemStateChanged

    private void RouteCaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RouteCaresActionPerformed
        new APICallAsync<EntityRefList<TCare>>(Busy, main) {
            @Override
            public Call<EntityRefList<TCare>> apiFun() {
                String routeKey = "";
                if (routes.size()!=0)
                    routeKey = routes.get(RouteList.getSelectedIndex()).getRouteKey();
                return main2.service2.getActualCares(main.debugToken,routeKey);
                }
            @Override
            public void onSucess(EntityRefList<TCare> oo) {
                cares = oo;
                System.out.println("Загружено "+oo.size()+" бортов");
                CaresList.removeAll();
                for(TCare care : cares)
                    CaresList.add(care.toString(typeMap));
                refreshCareStory();
                }
            };
    }//GEN-LAST:event_RouteCaresActionPerformed

    private void NearestCaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NearestCaresActionPerformed
        try {
            double dd1 = Double.parseDouble(GPSX.getText());
            double dd2 = Double.parseDouble(GPSY.getText());
            int diff = Integer.parseInt(Distance.getText());
            new APICallAsync<EntityRefList<TCare>>(Busy, main) {
                @Override
                public Call<EntityRefList<TCare>> apiFun() {
                    return main2.service2.getNearestCares(main.debugToken,diff,new GPSPoint(dd2,dd1,true));
                    }
                @Override
                public void onSucess(EntityRefList<TCare> oo) {
                    cares = oo;
                    System.out.println("Загружено "+oo.size()+" бортов");
                    CaresList.removeAll();
                    for(TCare care : cares)
                        CaresList.add(care.toString(typeMap));
                    refreshCareStory();
                    }
                };
            } catch (Exception ee){
                popup("Ошибка формата координат или дистанции");
                }

    }//GEN-LAST:event_NearestCaresActionPerformed

    private void refreshCareStory(){
        CarePoints.removeAll();
        if (cares.size()==0)
            return;
        final TCare care = cares.get(CaresList.getSelectedIndex());
        CarePoints.removeAll();
        new APICall<TCare>(main) {
            @Override
            public Call<TCare> apiFun() {
                return main2.service2.getCareStory(main.debugToken,care.getCareKey());
                }
            @Override
            public void onSucess(TCare oo) {
                StorySize.setText(""+oo.getCareStory().size());
                for(TCarePoint point : oo.getCareStory())
                    CarePoints.add(point.toString());
                    }
                };
        }

    private void CaresListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CaresListItemStateChanged
        refreshCareStory();
    }//GEN-LAST:event_CaresListItemStateChanged

    private void SegmentsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SegmentsItemStateChanged
        refreshOneSegment();
    }//GEN-LAST:event_SegmentsItemStateChanged

    public void refreshRoads(){
        new APICallAsync<EntityRefList<TSegment>>(Busy, main) {
            @Override
            public Call<EntityRefList<TSegment>> apiFun() {
                return main2.service2.getRoads(main.debugToken);
                }
            @Override
            public void onSucess(EntityRefList<TSegment> oo) {
                roads = oo;
                System.out.println("Загружено "+oo.size()+" сегментов");
                }
            };
        }
    public void refreahRoutes(){
        new APICallAsync<ArrayList<DBRequest>>(Busy,main) {
            @Override
            public Call<ArrayList<DBRequest>> apiFun() {
                return main.service.getEntityList(main.debugToken,"TRoute",ValuesBase.GetAllModeActual,0);
                }
            @Override
            public void onSucess(ArrayList<DBRequest> oo) {
                routes.clear();
                RouteList.removeAll();
                for(DBRequest dbRequest : oo){
                    try {
                        TRoute route = (TRoute)dbRequest.get(main.gson);
                        routes.add(route);
                        RouteList.add(route.getTitle(typeMap)+" "+route.getStopName1()+"-"+route.getStopName2());
                        } catch (UniException e) {
                            System.out.println("Ошибка json: "+e.toString());
                            }
                    }
                refreshStops();
                refreshRoads();
                }
            };
        }
    public void refreshSegments(){
        new APICallAsync<ArrayList<DBRequest>>(Busy,main) {
            @Override
            public Call<ArrayList<DBRequest>> apiFun() {
                return main.service.getEntityList(main.debugToken,"TSegment",ValuesBase.GetAllModeActual,0);
                }
            @Override
            public void onSucess(ArrayList<DBRequest> oo) {
                segments.clear();
                Segments.removeAll();
                for(DBRequest dbRequest : oo){
                    try {
                        TSegment segment = (TSegment) dbRequest.get(main.gson);
                        segments.add(segment);
                        Segments.add(segment.getTitle());
                        } catch (UniException e) {
                            System.out.println("Ошибка json: "+e.toString());
                            }
                    }
                refreshOneSegment();
                }
            };
        }
    public void  refreshOneSegmentFull(final int idx){
        new APICallAsync<DBRequest>(Busy,main) {
            @Override
            public Call<DBRequest> apiFun() {
                return main.service.getEntity(main.debugToken,"TSegment",segments.get(idx).getOid(),1);
                }
            @Override
            public void onSucess(DBRequest oo) {
                TSegment segment = null;
                try {
                    segment = (TSegment)oo.get(main.gson);
                    segments.remove(idx);
                    segments.add(idx,segment);
                    Segments.removeAll();
                    for(TSegment segment1 : segments){
                        Segments.add(segment1.getTitle());
                        }
                    Segments.select(idx);
                    } catch (UniException e) {
                        System.out.println("Ошибка JSON: "+e.toString());
                        }
                    }
                };
        }
    public void  refreshOneSegment(){
        if (segments.size()==0)
            return;
        final int idx = Segments.getSelectedIndex();
        new APICallAsync<TSegmentStatistic>(Busy,main) {
            @Override
            public Call<TSegmentStatistic> apiFun() {
                return main2.service2.getSegmentStatistic(main.debugToken,segments.get(idx).getOid());
                }
            @Override
            public void onSucess(TSegmentStatistic oo) {
                SegmentTotalCount.setText(""+oo.getTotalValues());
                SegmentNotNull.setText(""+oo.getNotNullCellCount());
                refreshOneSegmentFull(idx);
                }
            };
        }
    public void refreshStops(){
        StopList.removeAll();
        if (routes.size()==0){
            cRoute = null;
            return;
            }
        cRoute = routes.get(RouteList.getSelectedIndex());
        new APICallAsync<DBRequest>(Busy,main){
            @Override
            public Call<DBRequest> apiFun() {
                return main.service.getEntity(main.debugToken,"TRoute",cRoute.getOid(),2);
                }
            @Override
            public void onSucess(DBRequest oo) {
                try {
                    cRoute = (TRoute) oo.get(main.gson);
                    for (TRouteStop stop : cRoute.getStops())
                        StopList.add(stop.getStop().getRef().getName());
                    } catch (UniException e) {
                        System.out.println("Ошибка json: "+e.toString());
                        }
                }
            };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busy;
    private java.awt.Choice CarePoints;
    private java.awt.Choice CaresList;
    private javax.swing.JTextField Distance;
    private javax.swing.JTextField GPSX;
    private javax.swing.JTextField GPSY;
    private javax.swing.JButton GorTransImport;
    private javax.swing.JButton NearestCares;
    private javax.swing.JButton RouteCares;
    private java.awt.Choice RouteList;
    private javax.swing.JButton ScanOnOff;
    private javax.swing.JTextField SegmentNotNull;
    private javax.swing.JTextField SegmentTotalCount;
    private java.awt.Choice Segments;
    private java.awt.Choice StopList;
    private javax.swing.JTextField StorySize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
