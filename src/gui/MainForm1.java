package gui;

import com.sun.java.swing.plaf.windows.WindowsScrollPaneUI;
import entity.AccountDetail;
import entity.AccountHolder;
import entity.Product;

import entity.Users;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import net.java.dev.designgridlayout.DesignGridLayout;
import services.AccountServices;
import services.ProductServices;
import services.UserServices;

/**
 *
 * @author ehsas
 */
public class MainForm1 extends javax.swing.JFrame {

    public MainForm1 mainForm;


    private AddProductForm addProductForm;
    private LogoutForm logoutForm;
    private AddAdmin addAdmin;
    
    private AddAccount addAccountForm;
    private LedgerEntryForm ledgerEntryForm;
    private UpdateAccount updateAccountForm;
    private LedgerUpdateForm ledgerUpdateForm;
    private LedgerDailyDataForm ledgerDailyDataForm;
    private LedgerDataBtnDatesForm ledgerDataBtnDatesForm;

    // JInternal Form
    private JInternalFrame DeleteLogoForm;
    private JInternalFrame productImageForm;
    private JInternalFrame MySlidersForm;
    private JInternalFrame OurPagesForm;
    private JInternalFrame OurSubCat;
    private JInternalFrame locationForm;
    private JInternalFrame OurProducts;
    private JInternalFrame ourProductsAll;
    private JInternalFrame OurSubProducts;
    private JInternalFrame myAttributeValueForm;
    private JInternalFrame insertProAtt;
    private JInternalFrame insertNewProAtt;
    private JInternalFrame OurCategoryForm;
    private JInternalFrame OurAttributes;
    private JInternalFrame productAttributes;
    private JInternalFrame OurAttributesValues;
    private JInternalFrame editProductForm;
    private JInternalFrame allCustomerForm;
    private JInternalFrame subAdminForm;
    private JInternalFrame cancellOrderForm;
    private JInternalFrame deliveredllOrderForm;
    private JInternalFrame pendingOrderForm;
    
    private JInternalFrame allAccountHolderDetail;
    private JInternalFrame singleAccountHlderDetail;
    private JInternalFrame LegerDailyDetailForm;
    private JInternalFrame allTotalDetailForm;
    private JInternalFrame btnDatesForm;

    // Services
private UserServices userServices;
private ProductServices productServices;

private AccountServices accountServices;

    JPanel attPanel;
    JPanel panelIn;
    JPanel panel;
    JPanel paneldes;
    String attId;
    String productId;
    JCheckBox cbAttribute;

    boolean myStatus = false;

    public MainForm1() {
        initComponents();
        //changFormIcone();

        try {
            this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        } catch (Exception ex) {

        }

        setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);

        jScrollPane1.setUI(new WindowsScrollPaneUI());

        menueBar.setUI(new BasicMenuBarUI() {
            public void paint(Graphics g, JComponent c) {
                g.setColor(new Color(255, 201, 14));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

        desktopPane.setUI(new BasicDesktopPaneUI() {
            public void paint(Graphics g, JComponent c) {
                //c.setSize(1500, 1500);
//                g.setColor(new Color(250, 250, 250));
                g.setColor(new Color(252, 242, 209));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
        
        showAllDetail();

    }

    public void changFormIcone() {

        try {
            URL url = getClass().getResource("/logo.png");
            ImageIcon imgIcon = new ImageIcon(url);
            java.awt.Image image = imgIcon.getImage();

            this.setIconImage(image);

        } catch (Exception e) {
        }

    }

    public void displayAllproduct() {
        btnTitleOne.setText("Home");
        btnTitleTwo.setVisible(false);
        btnTitleThree.setVisible(false);

        hideMyForms();
        showOurProducts();
    }

    public void changeBtnColor() {
        btnTitleOne.setBackground(Color.WHITE);
        btnTitleTwo.setBackground(Color.WHITE);
        btnTitleThree.setBackground(Color.WHITE);

        btnTitleOne.setForeground(Color.BLACK);
        btnTitleTwo.setForeground(Color.BLACK);
        btnTitleThree.setForeground(Color.BLACK);
    }

    public void btnOneBg() {
        btnTitleOne.setBackground(Color.BLACK);
        btnTitleOne.setForeground(Color.WHITE);
    }

    public void btnTwoBg() {
      
        btnTitleTwo.setBackground(Color.BLACK);
        btnTitleTwo.setForeground(Color.WHITE);
    }

    public void btnThreeBg() {
        btnTitleThree.setBackground(Color.BLACK);
        btnTitleThree.setForeground(Color.WHITE);
    }

    public void hideBtnThree() {
        btnTitleThree.setVisible(false);
    }

    public void hideBtnTwo() {
        btnTitleTwo.setVisible(false);
    }

    public void ShowBtnThree() {
        btnTitleThree.setVisible(true);
    }

    public void ShowBtnTwo() {
        btnTitleTwo.setVisible(true);
    }

    public void setTextBtnThree(String btnTxt) {
        btnTitleThree.setText(btnTxt);
    }

    public void setTextBtnTwo(String btnTxt) {
        btnTitleTwo.setText(btnTxt);
    }

    public void displyForm(String status) {

        hideMyForms();
        changeBtnColor();
        btnTwoBg();
        btnTitleThree.setVisible(false);
        if (status.equals("My logos")) {
            //showOurLogos();
            this.dispose();
        } else if (status.equals("My sliders")) {
           // showMySliders();
            this.dispose();
        } else if (status.equals("Our pages")) {
            //showOurPages();
            this.dispose();
        } else if (status.equals("Our categories")) {
           // showOurCategories();

        } else if (status.equals("View admin List")) {
            showSubAdmin();
            this.dispose();
        } else if (status.equals("Our locations")) {
            //showOurLocation();
            this.dispose();
        } else if (status.equals("All attributes")) {
            //showOurAttributeForm();
            this.dispose();
        } else if (status.equals("Our attributes values")) {
            //showOurAttributeValueForm();
            this.dispose();
        }
        
         else if (status.equals("Add Account Holder")) {
            //showOurAttributeForm();
            this.dispose();
        } else if (status.equals("All Account Holder Detail")) {
            showAccountHolderDetail();
            this.dispose();
        }
    }
    
//     btnTitleOne.setText("Add Account Holder");
//            btnTitleTwo.setText("All Account Holder Detail");

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        pnlActionBar1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        btnLogo8 = new javax.swing.JButton();
        btnHome8 = new javax.swing.JButton();
        btnLogo9 = new javax.swing.JButton();
        btnHome9 = new javax.swing.JButton();
        btnLogo10 = new javax.swing.JButton();
        btnHome10 = new javax.swing.JButton();
        btnLogo11 = new javax.swing.JButton();
        btnHome11 = new javax.swing.JButton();
        menueBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnSliders = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnDeliveredOrder = new javax.swing.JButton();
        btnAttributeValue = new javax.swing.JButton();
        btnPendingOrder = new javax.swing.JButton();
        btnEntry = new javax.swing.JButton();
        btnCancelledOrder = new javax.swing.JButton();
        btnBusiness = new javax.swing.JButton();
        btnPages = new javax.swing.JButton();
        btnAttribute = new javax.swing.JButton();
        btnLocations = new javax.swing.JButton();
        btnLogo = new javax.swing.JButton();
        btnTitleOne = new javax.swing.JButton();
        btnTitleThree = new javax.swing.JButton();
        btnTitleTwo = new javax.swing.JButton();
        menueBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setText("                  Search");

        javax.swing.GroupLayout pnlActionBar1Layout = new javax.swing.GroupLayout(pnlActionBar1);
        pnlActionBar1.setLayout(pnlActionBar1Layout);
        pnlActionBar1Layout.setHorizontalGroup(
            pnlActionBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActionBar1Layout.createSequentialGroup()
                .addContainerGap(786, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        pnlActionBar1Layout.setVerticalGroup(
            pnlActionBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActionBar1Layout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jFrame1.getContentPane().add(pnlActionBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 40));

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jFrame1.getContentPane().add(jDesktopPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 680, 440));

        btnLogo8.setBackground(new java.awt.Color(255, 255, 255));
        btnLogo8.setText("Logos");
        btnLogo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo8MouseEntered(evt);
            }
        });
        jFrame1.getContentPane().add(btnLogo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 160, 50));

        btnHome8.setBackground(new java.awt.Color(255, 255, 255));
        btnHome8.setText("Home");
        btnHome8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome8FocusLost(evt);
            }
        });
        btnHome8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome8MouseExited(evt);
            }
        });
        jFrame1.getContentPane().add(btnHome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 160, 50));

        btnLogo9.setBackground(new java.awt.Color(255, 255, 255));
        btnLogo9.setText("Logos");
        btnLogo9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo9MouseEntered(evt);
            }
        });
        jFrame1.getContentPane().add(btnLogo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 160, 50));

        btnHome9.setBackground(new java.awt.Color(255, 255, 255));
        btnHome9.setText("Home");
        btnHome9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome9FocusLost(evt);
            }
        });
        btnHome9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome9MouseExited(evt);
            }
        });
        jFrame1.getContentPane().add(btnHome9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 160, 50));

        btnLogo10.setBackground(new java.awt.Color(255, 255, 255));
        btnLogo10.setText("Logos");
        btnLogo10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo10MouseEntered(evt);
            }
        });
        jFrame1.getContentPane().add(btnLogo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 160, 50));

        btnHome10.setBackground(new java.awt.Color(255, 255, 255));
        btnHome10.setText("Home");
        btnHome10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome10FocusLost(evt);
            }
        });
        btnHome10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome10MouseExited(evt);
            }
        });
        jFrame1.getContentPane().add(btnHome10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 50));

        btnLogo11.setBackground(new java.awt.Color(255, 255, 255));
        btnLogo11.setText("Logos");
        btnLogo11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo11MouseEntered(evt);
            }
        });
        jFrame1.getContentPane().add(btnLogo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, 50));

        btnHome11.setBackground(new java.awt.Color(255, 255, 255));
        btnHome11.setText("Home");
        btnHome11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome11FocusLost(evt);
            }
        });
        btnHome11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome11MouseExited(evt);
            }
        });
        jFrame1.getContentPane().add(btnHome11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 50));

        jMenu4.setText("File");

        jMenuItem2.setText("New Form");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        menueBar1.add(jMenu4);

        jMenu5.setText("Edit");
        menueBar1.add(jMenu5);

        jMenu6.setText("jMenu3");
        menueBar1.add(jMenu6);

        jFrame1.setJMenuBar(menueBar1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stores Viki");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(153, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 700));

        desktopPane.setAlignmentX(0.0F);
        desktopPane.setMaximumSize(new java.awt.Dimension(2147483647, 904));
        desktopPane.setPreferredSize(new java.awt.Dimension(700, 800));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 700));

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.setOpaque(false);
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setBackground(new java.awt.Color(255, 251, 252));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Home.png"))); // NOI18N
        btnHome.setText("  Home");
        btnHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusable(false);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHome.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btnHome.setOpaque(true);
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited1(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        pnlMenu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        btnCategory.setBackground(new java.awt.Color(255, 251, 252));
        btnCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/categories.png"))); // NOI18N
        btnCategory.setText("Docter");
        btnCategory.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnCategory.setBorderPainted(false);
        btnCategory.setContentAreaFilled(false);
        btnCategory.setFocusable(false);
        btnCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCategory.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCategory.setOpaque(true);
        btnCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCategoryMouseExited(evt);
            }
        });
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, 50));

        btnProduct.setBackground(new java.awt.Color(255, 251, 252));
        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products.png"))); // NOI18N
        btnProduct.setText("  Products");
        btnProduct.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnProduct.setBorderPainted(false);
        btnProduct.setContentAreaFilled(false);
        btnProduct.setFocusable(false);
        btnProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProduct.setOpaque(true);
        btnProduct.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductMouseExited(evt);
            }
        });
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        pnlMenu.add(btnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 50));

        btnCustomers.setBackground(new java.awt.Color(255, 251, 252));
        btnCustomers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customers.png"))); // NOI18N
        btnCustomers.setText("Target Docters");
        btnCustomers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnCustomers.setBorderPainted(false);
        btnCustomers.setContentAreaFilled(false);
        btnCustomers.setFocusable(false);
        btnCustomers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCustomers.setOpaque(true);
        btnCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHomeFocusLost(evt);
            }
        });
        btnCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, 50));

        btnLogOut.setBackground(new java.awt.Color(255, 251, 252));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        btnLogOut.setText("  Log Out");
        btnLogOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnLogOut.setBorderPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.setFocusable(false);
        btnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLogOut.setOpaque(true);
        btnLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        pnlMenu.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 200, 50));

        btnSliders.setBackground(new java.awt.Color(255, 251, 252));
        btnSliders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSliders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/entry.png"))); // NOI18N
        btnSliders.setText("Ledger Entry");
        btnSliders.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnSliders.setBorderPainted(false);
        btnSliders.setContentAreaFilled(false);
        btnSliders.setFocusable(false);
        btnSliders.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSliders.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSliders.setOpaque(true);
        btnSliders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSliders.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome6FocusLost(evt);
            }
        });
        btnSliders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome6MouseExited(evt);
            }
        });
        btnSliders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlidersActionPerformed(evt);
            }
        });
        pnlMenu.add(btnSliders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 50));

        btnAdmin.setBackground(new java.awt.Color(255, 251, 252));
        btnAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/admins.png"))); // NOI18N
        btnAdmin.setText("  Admins");
        btnAdmin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setFocusable(false);
        btnAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdmin.setOpaque(true);
        btnAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome2FocusLost(evt);
            }
        });
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome2MouseExited(evt);
            }
        });
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 200, 50));

        btnDeliveredOrder.setBackground(new java.awt.Color(255, 251, 252));
        btnDeliveredOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeliveredOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delivered order.png"))); // NOI18N
        btnDeliveredOrder.setText("Target Wards");
        btnDeliveredOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnDeliveredOrder.setBorderPainted(false);
        btnDeliveredOrder.setContentAreaFilled(false);
        btnDeliveredOrder.setFocusable(false);
        btnDeliveredOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeliveredOrder.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDeliveredOrder.setOpaque(true);
        btnDeliveredOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeliveredOrder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome1FocusLost(evt);
            }
        });
        btnDeliveredOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome1MouseExited(evt);
            }
        });
        btnDeliveredOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveredOrderActionPerformed(evt);
            }
        });
        pnlMenu.add(btnDeliveredOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 200, 50));

        btnAttributeValue.setBackground(new java.awt.Color(255, 251, 252));
        btnAttributeValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAttributeValue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/attribute valus.png"))); // NOI18N
        btnAttributeValue.setText("Sale Product");
        btnAttributeValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnAttributeValue.setBorderPainted(false);
        btnAttributeValue.setContentAreaFilled(false);
        btnAttributeValue.setFocusable(false);
        btnAttributeValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAttributeValue.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAttributeValue.setOpaque(true);
        btnAttributeValue.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAttributeValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAttributeValueMouseExited(evt);
            }
        });
        btnAttributeValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttributeValueActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAttributeValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, 50));

        btnPendingOrder.setBackground(new java.awt.Color(255, 251, 252));
        btnPendingOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPendingOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pending orders.png"))); // NOI18N
        btnPendingOrder.setText("Target Hospitals");
        btnPendingOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnPendingOrder.setBorderPainted(false);
        btnPendingOrder.setContentAreaFilled(false);
        btnPendingOrder.setFocusable(false);
        btnPendingOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPendingOrder.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPendingOrder.setOpaque(true);
        btnPendingOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPendingOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPendingOrderMouseExited(evt);
            }
        });
        btnPendingOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendingOrderActionPerformed(evt);
            }
        });
        pnlMenu.add(btnPendingOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 200, 50));

        btnEntry.setBackground(new java.awt.Color(255, 251, 252));
        btnEntry.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEntry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/entry.png"))); // NOI18N
        btnEntry.setText("  Entry");
        btnEntry.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnEntry.setBorderPainted(false);
        btnEntry.setContentAreaFilled(false);
        btnEntry.setFocusable(false);
        btnEntry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEntry.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEntry.setOpaque(true);
        btnEntry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome5FocusLost(evt);
            }
        });
        btnEntry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome5MouseExited(evt);
            }
        });
        btnEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntryActionPerformed(evt);
            }
        });
        pnlMenu.add(btnEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, 50));

        btnCancelledOrder.setBackground(new java.awt.Color(255, 251, 252));
        btnCancelledOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelledOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/canceled order.png"))); // NOI18N
        btnCancelledOrder.setText("  Cancelled Ordes");
        btnCancelledOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnCancelledOrder.setBorderPainted(false);
        btnCancelledOrder.setContentAreaFilled(false);
        btnCancelledOrder.setFocusable(false);
        btnCancelledOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelledOrder.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelledOrder.setOpaque(true);
        btnCancelledOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelledOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelledOrderMouseExited(evt);
            }
        });
        btnCancelledOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelledOrderActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCancelledOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 200, 50));

        btnBusiness.setBackground(new java.awt.Color(255, 251, 252));
        btnBusiness.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBusiness.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/business information.png"))); // NOI18N
        btnBusiness.setText("  Business Information");
        btnBusiness.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnBusiness.setBorderPainted(false);
        btnBusiness.setContentAreaFilled(false);
        btnBusiness.setFocusable(false);
        btnBusiness.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBusiness.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBusiness.setOpaque(true);
        btnBusiness.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusiness.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBusinessMouseExited(evt);
            }
        });
        btnBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusinessActionPerformed(evt);
            }
        });
        pnlMenu.add(btnBusiness, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 200, 50));

        btnPages.setBackground(new java.awt.Color(255, 251, 252));
        btnPages.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customers.png"))); // NOI18N
        btnPages.setText("Detail btn Dates");
        btnPages.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnPages.setBorderPainted(false);
        btnPages.setContentAreaFilled(false);
        btnPages.setFocusable(false);
        btnPages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPages.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPages.setOpaque(true);
        btnPages.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPages.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome4FocusLost(evt);
            }
        });
        btnPages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome4MouseExited(evt);
            }
        });
        btnPages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagesActionPerformed(evt);
            }
        });
        pnlMenu.add(btnPages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 50));

        btnAttribute.setBackground(new java.awt.Color(255, 251, 252));
        btnAttribute.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAttribute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/attributes.png"))); // NOI18N
        btnAttribute.setText("Target Products");
        btnAttribute.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnAttribute.setBorderPainted(false);
        btnAttribute.setContentAreaFilled(false);
        btnAttribute.setFocusable(false);
        btnAttribute.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAttribute.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAttribute.setOpaque(true);
        btnAttribute.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAttribute.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnHome3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnHome3FocusLost(evt);
            }
        });
        btnAttribute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome3MouseExited(evt);
            }
        });
        btnAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttributeActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAttribute, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, 50));

        btnLocations.setBackground(new java.awt.Color(255, 251, 252));
        btnLocations.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/locations.png"))); // NOI18N
        btnLocations.setText("Daily Detail");
        btnLocations.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnLocations.setBorderPainted(false);
        btnLocations.setContentAreaFilled(false);
        btnLocations.setFocusable(false);
        btnLocations.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLocations.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLocations.setOpaque(true);
        btnLocations.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogo4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLocationsMouseExited(evt);
            }
        });
        btnLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationsActionPerformed(evt);
            }
        });
        pnlMenu.add(btnLocations, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        btnLogo.setBackground(new java.awt.Color(255, 251, 252));
        btnLogo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customers.png"))); // NOI18N
        btnLogo.setText("Account Holder");
        btnLogo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnLogo.setBorderPainted(false);
        btnLogo.setContentAreaFilled(false);
        btnLogo.setFocusable(false);
        btnLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLogo.setIconTextGap(14);
        btnLogo.setMaximumSize(new java.awt.Dimension(67, 21));
        btnLogo.setMinimumSize(new java.awt.Dimension(67, 21));
        btnLogo.setName(""); // NOI18N
        btnLogo.setOpaque(true);
        btnLogo.setPreferredSize(new java.awt.Dimension(67, 21));
        btnLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoMouseEntered1(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoMouseExited1(evt);
            }
        });
        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoActionPerformed(evt);
            }
        });
        pnlMenu.add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 50));

        jScrollPane1.setViewportView(pnlMenu);

        btnTitleOne.setBackground(new java.awt.Color(0, 0, 0));
        btnTitleOne.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnTitleOne.setForeground(new java.awt.Color(255, 255, 255));
        btnTitleOne.setText("Title 1");
        btnTitleOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTitleOneActionPerformed(evt);
            }
        });

        btnTitleThree.setBackground(new java.awt.Color(255, 255, 255));
        btnTitleThree.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnTitleThree.setText("Title 3");
        btnTitleThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTitleThreeActionPerformed(evt);
            }
        });

        btnTitleTwo.setBackground(new java.awt.Color(255, 255, 255));
        btnTitleTwo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnTitleTwo.setText("Title 2");
        btnTitleTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTitleTwoActionPerformed(evt);
            }
        });

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Exit");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menueBar.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Windows");
        menueBar.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Help");
        menueBar.add(jMenu3);

        setJMenuBar(menueBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTitleOne, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTitleTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTitleThree, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(208, Short.MAX_VALUE))
                    .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitleOne, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTitleTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTitleThree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnLogo8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogo8MouseEntered

    private void btnHome8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome8FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome8FocusGained

    private void btnHome8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome8FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome8FocusLost

    private void btnHome8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome8MouseEntered

    private void btnHome8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome8MouseExited

    private void btnLogo9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogo9MouseEntered

    private void btnHome9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome9FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome9FocusGained

    private void btnHome9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome9FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome9FocusLost

    private void btnHome9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome9MouseEntered

    private void btnHome9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome9MouseExited

    private void btnLogo10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogo10MouseEntered

    private void btnHome10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome10FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome10FocusGained

    private void btnHome10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome10FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome10FocusLost

    private void btnHome10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome10MouseEntered

    private void btnHome10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome10MouseExited

    private void btnLogo11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogo11MouseEntered

    private void btnHome11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome11FocusGained

    private void btnHome11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome11FocusLost

    private void btnHome11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome11MouseEntered

    private void btnHome11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome11MouseExited

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnLogo4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo4MouseEntered
        btnLocations.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo4MouseEntered

    private void btnHome3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome3MouseExited
        btnAttribute.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHome3MouseExited

    private void btnHome3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome3MouseEntered
        btnAttribute.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome3MouseEntered

    private void btnHome3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome3FocusLost

    private void btnHome3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome3FocusGained

    private void btnHome4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome4MouseExited
        btnPages.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHome4MouseExited

    private void btnHome4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome4MouseEntered
        btnPages.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome4MouseEntered

    private void btnHome4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome4FocusLost

    private void btnHome4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome4FocusGained

    private void btnLogo12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo12MouseEntered
        btnBusiness.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo12MouseEntered

    private void btnLogo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo1MouseEntered
        btnCancelledOrder.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo1MouseEntered

    private void btnHome5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome5MouseExited
        btnEntry.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHome5MouseExited

    private void btnHome5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome5MouseEntered
        btnEntry.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome5MouseEntered

    private void btnHome5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome5FocusLost

    private void btnHome5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome5FocusGained

    private void btnLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoMouseEntered
        btnPendingOrder.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogoMouseEntered

    private void btnLogo3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo3MouseEntered
        btnAttributeValue.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo3MouseEntered

    private void btnHome1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome1MouseExited
        btnDeliveredOrder.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHome1MouseExited

    private void btnHome1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome1MouseEntered
        btnDeliveredOrder.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome1MouseEntered

    private void btnHome1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome1FocusLost

    private void btnHome1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome1FocusGained

    private void btnHome2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome2MouseExited
        btnAdmin.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHome2MouseExited

    private void btnHome2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome2MouseEntered
        btnAdmin.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome2MouseEntered

    private void btnHome2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome2FocusLost

    private void btnHome2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome2FocusGained

    private void btnHome6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome6MouseExited
        btnSliders.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHome6MouseExited

    private void btnHome6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome6MouseEntered
        btnSliders.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome6MouseEntered

    private void btnHome6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome6FocusLost

    private void btnHome6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHome6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome6FocusGained

    private void btnLogo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo2MouseEntered
        btnLogOut.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo2MouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnCustomers.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnCustomers.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHomeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeFocusLost

    private void btnHomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnHomeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeFocusGained

    private void btnLogo6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo6MouseEntered
        btnProduct.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo6MouseEntered

    private void btnLogo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogo5MouseEntered
        btnCategory.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogo5MouseEntered

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

        showAllDetail();

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHome7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome7MouseEntered

        btnHome.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnHome7MouseEntered

    private void btnLogoMouseEntered1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoMouseEntered1
        btnLogo.setBackground(new Color(248, 230, 230));
    }//GEN-LAST:event_btnLogoMouseEntered1

    private void btnLogoMouseExited1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoMouseExited1
        btnLogo.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnLogoMouseExited1

    private void btnHomeMouseExited1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited1

        btnHome.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnHomeMouseExited1

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Log out");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

//            logoutForm = new LogoutForm();
//            desktopPane.add(logoutForm);
//            logoutForm.setVisible(true);
//            logoutForm.setMaximum(true);
        } catch (Exception ex) {
            //Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttributeActionPerformed
        try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Add attribute");
            btnTitleTwo.setText("All attributes");
            btnTitleTwo.setVisible(true);
            btnTitleThree.setVisible(false);

//            hideMyForms();
//            addAttributesForm = new AddWardForm();
//            desktopPane.add(addAttributesForm);
//            addAttributesForm.setVisible(true);
//            addAttributesForm.setMaximum(true);
        } catch (Exception ex) {
            //Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAttributeActionPerformed

    private void btnPagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagesActionPerformed
    try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Detail btn Dates");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

            hideMyForms();
            ledgerDataBtnDatesForm = new LedgerDataBtnDatesForm();
            desktopPane.add(ledgerDataBtnDatesForm);
            ledgerDataBtnDatesForm.setVisible(true);
            ledgerDataBtnDatesForm.setMaximum(true);
        } catch (Exception ex) {
            //Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPagesActionPerformed

    private void btnLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationsActionPerformed
        try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Daily Detail");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

            hideMyForms();
            ledgerDailyDataForm = new LedgerDailyDataForm();
            desktopPane.add(ledgerDailyDataForm);
            ledgerDailyDataForm.setVisible(true);
            ledgerDailyDataForm.setMaximum(true);
        } catch (Exception ex) {
            //Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLocationsActionPerformed

    private void btnEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntryActionPerformed
        try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Add product");
            btnTitleTwo.setText("All products");
            btnTitleTwo.setVisible(true);
            btnTitleThree.setVisible(false);

//            hideMyForms();
//            addProductForm = new AddProductForm();
//            desktopPane.add(addProductForm);
//            addProductForm.setVisible(true);
//            addProductForm.setMaximum(true);
        } catch (Exception ex) {
            // Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEntryActionPerformed

    private void btnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoActionPerformed

         try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Add Account Holder");
            btnTitleTwo.setText("All Account Holder Detail");
            btnTitleTwo.setVisible(true);
            btnTitleThree.setVisible(false);

            hideMyForms();
            addAccountForm = new AddAccount();
            desktopPane.add(addAccountForm);
            addAccountForm.setVisible(true);
            addAccountForm.setMaximum(true);
        } catch (Exception ex) {
            // Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLogoActionPerformed

    private void btnSlidersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlidersActionPerformed

        try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Ledger Entry");
            btnTitleTwo.setText("All Ledger Entry");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

            hideMyForms();
            ledgerEntryForm = new LedgerEntryForm();
            desktopPane.add(ledgerEntryForm);
            ledgerEntryForm.setVisible(true);
            ledgerEntryForm.setMaximum(true);
        } catch (Exception ex) {
            // Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSlidersActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed

    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        btnTitleOne.setText("All products");
        btnTitleTwo.setVisible(false);
        btnTitleThree.setVisible(false);

        hideMyForms();
        showOurProductsAll();
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnAttributeValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttributeValueActionPerformed
        changeBtnColor();
        btnOneBg();
        btnTitleTwo.setVisible(true);
        btnTitleOne.setText("Add ttributes values");
        btnTitleTwo.setText("Our attributes values");
        btnTitleThree.setVisible(false);

        hideMyForms();
        //showAddAttributeValueForm();

    }//GEN-LAST:event_btnAttributeValueActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        changeBtnColor();
        btnOneBg();
        btnTitleTwo.setVisible(true);
        btnTitleOne.setText("Customers");
        btnTitleTwo.setVisible(false);
        btnTitleThree.setVisible(false);

        hideMyForms();
        //showAllCustomer();
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnPendingOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendingOrderActionPerformed
        changeBtnColor();
        btnOneBg();
        btnTitleOne.setText("Pending orders");
        btnTitleTwo.setVisible(false);
        btnTitleThree.setVisible(false);

        hideMyForms();
       // showPendingOrder();
    }//GEN-LAST:event_btnPendingOrderActionPerformed

    private void btnDeliveredOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveredOrderActionPerformed
        changeBtnColor();
        btnOneBg();
        btnTitleOne.setText("Delivered orders");
        btnTitleTwo.setVisible(false);
        btnTitleThree.setVisible(false);

        hideMyForms();
       // showDeliveredOrder();
    }//GEN-LAST:event_btnDeliveredOrderActionPerformed

    private void btnCancelledOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelledOrderActionPerformed
        changeBtnColor();
        btnOneBg();
        btnTitleOne.setText("Cancelled orders");
        btnTitleTwo.setVisible(false);
        btnTitleThree.setVisible(false);

        hideMyForms();
        //showCancelledOrder();
    }//GEN-LAST:event_btnCancelledOrderActionPerformed

    void showAllDetail() {
         changeBtnColor();
        btnOneBg();
        btnTitleOne.setText("All Total Detail");
        btnTitleTwo.setText("Report Total Detail");
        btnTitleTwo.setVisible(true);
        btnTitleThree.setVisible(false);

        hideMyForms();
        showAllTotalDetails();
    }
    
    private void btnBusinessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusinessActionPerformed
        try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Edit business");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

//            hideMyForms();
//            updateBusinessForm = new UpdateBusinessForm();
//            desktopPane.add(updateBusinessForm);
//            updateBusinessForm.setVisible(true);
//            updateBusinessForm.setMaximum(true);
        } catch (Exception ex) {
            // Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnBusinessActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        try {
            changeBtnColor();
            btnOneBg();
            btnTitleTwo.setVisible(true);
            btnTitleOne.setText("Add admin");
            btnTitleTwo.setText("View admin List");
            btnTitleThree.setVisible(false);

//            hideMyForms();
//            addAdmin = new AddAdmin();
//            desktopPane.add(addAdmin);
//            addAdmin.setVisible(true);
//            addAdmin.setMaximum(true);
        } catch (Exception ex) {
            //Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnTitleTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitleTwoActionPerformed

        //All Detail Daily
        
        String status = btnTitleTwo.getText();
        if (status.equals("All Ledger Entry")) {
            
        } else if (status.equals("All Detail Daily")) {
            
        }else if (status.equals("All Detail Between Dates")) {
            
        }
        
        else {
            hideMyForms();
            changeBtnColor();
            btnTwoBg();
            btnTitleThree.setVisible(false);
        }
       
        

        if (status.equals("My logos")) {
           // showOurLogos();
        } else if (status.equals("My sliders")) {
           // showMySliders();
        } else if (status.equals("Our pages")) {
            //showOurPages();
        } else if (status.equals("Our categories")) {
           // showOurCategories();
        } else if (status.equals("View admin List")) {
            showSubAdmin();
        } else if (status.equals("Our locations")) {
            //showOurLocation();
        } else if (status.equals("All attributes")) {
            //showOurAttributeForm();
        } else if (status.equals("Our attributes values")) {
            //showOurAttributeValueForm();
        } else if (status.equals("Edit Product")) {
            //showEditProductForm(productId);
        } else if (status.equals("All products")) {
            showOurProductsAll();
        }
        
        else if (status.equals("All Account Holder Detail")) {
            showAccountHolderDetail();
        }
        
      
    }//GEN-LAST:event_btnTitleTwoActionPerformed

    private void btnTitleOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitleOneActionPerformed

        String status = btnTitleOne.getText();

        changeBtnColor();
        btnOneBg();
        btnTitleThree.setVisible(false);

        if (status.equals("Add admin")) {

            hideMyForms();
            addAdmin = new AddAdmin();
            desktopPane.add(addAdmin);
            addAdmin.setVisible(true);
            try {
                addAdmin.setMaximum(true);
            } catch (Exception ex) {
            }

        } else if (status.equals("Home")) {

            hideMyForms();
            //showOurProducts();

        } else if (status.equals("All Account Holder Detail")) {

            hideMyForms();
            showAccountHolderDetail();

        } else if (status.equals("Add product")) {

            try {
                changeBtnColor();
                btnOneBg();
                hideMyForms();
                addProductForm = new AddProductForm();
                desktopPane.add(addProductForm);
                addProductForm.setVisible(true);
                addProductForm.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }
        } else if (status.equals("All Total Detail")) {

            changeBtnColor();
            showAllDetail();
        }else if (status.equals("Add Account Holder")) {
             try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Add Account Holder");
            btnTitleTwo.setText("All Account Holder Detail");
            btnTitleTwo.setVisible(true);
            btnTitleThree.setVisible(false);

            hideMyForms();
            addAccountForm = new AddAccount();
            desktopPane.add(addAccountForm);
            addAccountForm.setVisible(true);
            addAccountForm.setMaximum(true);
        } catch (Exception ex) {
            // Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if (status.equals("Ledger Entry")) {
            
            try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Ledger Entry");
            btnTitleTwo.setText("All Ledger Entry");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

            hideMyForms();
            ledgerEntryForm = new LedgerEntryForm();
            desktopPane.add(ledgerEntryForm);
            ledgerEntryForm.setVisible(true);
            ledgerEntryForm.setMaximum(true);
        } catch (Exception ex) {
            // Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }else if (status.equals("Daily Detail")) {
            
            try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Daily Detail");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

            hideMyForms();
            ledgerDailyDataForm = new LedgerDailyDataForm();
            desktopPane.add(ledgerDailyDataForm);
            ledgerDailyDataForm.setVisible(true);
            ledgerDailyDataForm.setMaximum(true);
        } catch (Exception ex) {
        }
        }else if (status.equals("Detail btn Dates")) {
            
          try {
            changeBtnColor();
            btnOneBg();
            btnTitleOne.setText("Detail btn Dates");
            btnTitleTwo.setVisible(false);
            btnTitleThree.setVisible(false);

            hideMyForms();
            ledgerDataBtnDatesForm = new LedgerDataBtnDatesForm();
            desktopPane.add(ledgerDataBtnDatesForm);
            ledgerDataBtnDatesForm.setVisible(true);
            ledgerDataBtnDatesForm.setMaximum(true);
        } catch (Exception ex) {
            //Logger.getLogger(MainForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
       
         
    }//GEN-LAST:event_btnTitleOneActionPerformed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked


    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoryMouseExited

        btnCategory.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnCategoryMouseExited

    private void btnProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseExited
        btnProduct.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnProductMouseExited

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        btnLogOut.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnLogOutMouseExited

    private void btnAttributeValueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttributeValueMouseExited
        btnAttributeValue.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnAttributeValueMouseExited

    private void btnPendingOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendingOrderMouseExited
        btnPendingOrder.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnPendingOrderMouseExited

    private void btnCancelledOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelledOrderMouseExited
        btnCancelledOrder.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnCancelledOrderMouseExited

    private void btnBusinessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusinessMouseExited
        btnBusiness.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnBusinessMouseExited

    private void btnLocationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLocationsMouseExited
        btnLocations.setBackground(new Color(255, 251, 252));
    }//GEN-LAST:event_btnLocationsMouseExited

    private void btnTitleThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitleThreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTitleThreeActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1MouseClicked

    // Show Account Holder Detail
    
    public void showAccountHolderDetail() {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading Account Holder Detail ...");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                allAccountHolderDetail = new JInternalFrame();

                accountServices = new AccountServices();
                List<AccountHolder> vectorAccountHolderDetail = accountServices.getAccountHolderAllDetail();

                JLabel lblUpdate;
                JLabel lblCancel;

                URL url = getClass().getResource("/icons/Edit.png");
                ImageIcon iconUpdate = new ImageIcon(url);

                URL url2 = getClass().getResource("/icons/Delete.png");
                ImageIcon iconDelete = new ImageIcon(url2);

                JPanel panel;
                Box box = new Box(BoxLayout.Y_AXIS);

                for (int i = 0; i < vectorAccountHolderDetail.size(); i++) {

                    panel = new JPanel();
                    lblUpdate = new JLabel(iconUpdate);
                    lblCancel = new JLabel(iconDelete);

                    JLabel lblName = new JLabel("<html><table><tr><td width='150'>" + vectorAccountHolderDetail.get(i).getName()+ "</td></tr></table></html>");
                    JLabel lblAddress = new JLabel("<html><table><tr><td width='150'>" + vectorAccountHolderDetail.get(i).getMobileNum()+ "</td></tr></table></html>");
                    JLabel lblMobileNum = new JLabel("<html><table><tr><td width='300'>" + vectorAccountHolderDetail.get(i).getAddress()+ "</td></tr></table></html>");
                    panel.add(lblName);
                    panel.add(lblAddress);
                    panel.add(lblMobileNum);
                    //panel.add(Box.createHorizontalStrut(20));
                    panel.add(lblUpdate);
                    panel.add(lblCancel);

                    lblUpdate.putClientProperty("id", vectorAccountHolderDetail.get(i).getAccountHolderId());
                    lblUpdate.putClientProperty("name", vectorAccountHolderDetail.get(i).getName());
                    lblUpdate.putClientProperty("mobile", vectorAccountHolderDetail.get(i).getMobileNum());
                    lblUpdate.putClientProperty("address", vectorAccountHolderDetail.get(i).getAddress());

                    lblCancel.putClientProperty("id", vectorAccountHolderDetail.get(i).getAccountHolderId());

                    panel.setBackground(Color.WHITE);
                    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    panel.setMaximumSize(new Dimension(getHeight() * 2, 40));
                    box.add(panel);

                    lblCancel.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent me) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Account Holder detail?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object command = ((JLabel) me.getSource()).getClientProperty("id");
                                //System.out.println("the id is "+command.toString());
                                String userId = command.toString();
                                boolean status = accountServices.deleteAccountHolderDetail(userId);
                                if (status == true) {
                                    JOptionPane.showMessageDialog(null, "Account detail deleted");
                                    hideMyForms();
                                    showAccountHolderDetail();

                                } else {
                                    JOptionPane.showMessageDialog(null, "Account detail not deleted");
                                }
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });

                    lblUpdate.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent me) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update Account Holder detail?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object myId = ((JLabel) me.getSource()).getClientProperty("id");
                                Object myName = ((JLabel) me.getSource()).getClientProperty("name");
                                Object mymobile = ((JLabel) me.getSource()).getClientProperty("mobile");
                                Object myAddress = ((JLabel) me.getSource()).getClientProperty("address");

                                //System.out.println("the id is "+command.toString());
                                String accountId = myId.toString();
                                String name = myName.toString();
                                String mobile = mymobile.toString();
                                String address = myAddress.toString();
                                    btnTitleOne.setText("Add Account Holder");
                                    btnTitleTwo.setText("All Account Holder Detail");
                                    btnTitleThree.setText("Update Account Holder Detail");
                                    btnTitleTwo.setVisible(true);
                                    btnTitleThree.setVisible(true);
                                    changeBtnColor();
                                    btnThreeBg();
                                    
                                hideMyForms();
                                updateAccountForm = new UpdateAccount();
                                desktopPane.add(updateAccountForm);
                                updateAccountForm.displayInfo(name, mobile, address, accountId);
                                updateAccountForm.setVisible(true);
                                try {
                                    updateAccountForm.setMaximum(true);
                                } catch (Exception ex) {

                                }
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                }
                box.setOpaque(true);
                box.setBackground(Color.WHITE);
                box.setOpaque(true);
                box.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(box);

                allAccountHolderDetail.add(sp, BorderLayout.CENTER);
                allAccountHolderDetail.pack();
                allAccountHolderDetail.setOpaque(false);
                allAccountHolderDetail.getContentPane().setBackground(Color.WHITE);
                allAccountHolderDetail.setSize(764, 562);
                allAccountHolderDetail.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = allAccountHolderDetail.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
                allAccountHolderDetail.setVisible(true);
                desktopPane.add(allAccountHolderDetail);
                allAccountHolderDetail.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }
    
    ////////////////////////////
 

   
    public void showSubAdmin() {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading admin information ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                subAdminForm = new JInternalFrame();

                userServices = new UserServices();
                List<Users> vectorSubAdmin = userServices.getSubAdmin();

                JLabel lblUpdate;
                JLabel lblCancel;

                URL url = getClass().getResource("/icons/Edit.png");
                ImageIcon iconUpdate = new ImageIcon(url);

                URL url2 = getClass().getResource("/icons/Delete.png");
                ImageIcon iconDelete = new ImageIcon(url2);

                JPanel panel;
                Box box = new Box(BoxLayout.Y_AXIS);

                for (int i = 0; i < vectorSubAdmin.size(); i++) {

                    panel = new JPanel();
                    lblUpdate = new JLabel(iconUpdate);
                    lblCancel = new JLabel(iconDelete);

                    JLabel lblAdminName = new JLabel("<html><table><tr><td width='600'>" + vectorSubAdmin.get(i).getUsername() + "</td></tr></table></html>");

                    panel.add(lblAdminName);
                    //panel.add(Box.createHorizontalStrut(20));
                    panel.add(lblUpdate);
                    panel.add(lblCancel);

                    lblUpdate.putClientProperty("id", vectorSubAdmin.get(i).getUserId());
                    lblUpdate.putClientProperty("name", vectorSubAdmin.get(i).getUsername());
                    //lblUpdate.putClientProperty("pass", vectorSubAdmin.get(i).getPassword());

                    lblCancel.putClientProperty("id", vectorSubAdmin.get(i).getUserId());

                    panel.setBackground(Color.WHITE);
                    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    panel.setMaximumSize(new Dimension(getHeight() * 2, 40));
                    box.add(panel);

                    lblCancel.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent me) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete admin?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object command = ((JLabel) me.getSource()).getClientProperty("id");
                                //System.out.println("the id is "+command.toString());
                                String userId = command.toString();
                                boolean status = userServices.deleteAdmin(userId);
                                if (status == true) {
                                    JOptionPane.showMessageDialog(null, "Admin deleted");
                                    hideMyForms();
                                    showSubAdmin();

                                } else {
                                    JOptionPane.showMessageDialog(null, "Admin not deleted");
                                }
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });

                    lblUpdate.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent me) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update customer?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object myId = ((JLabel) me.getSource()).getClientProperty("id");
                                Object myName = ((JLabel) me.getSource()).getClientProperty("name");
                                //Object mypass = ((JLabel) me.getSource()).getClientProperty("pass");

                                //System.out.println("the id is "+command.toString());
                                String userId = myId.toString();
                                String uName = myName.toString();
                                // String pass = mypass.toString();

                                btnTitleOne.setText("Add admin");
                                btnTitleTwo.setText("View admin List");
                                btnTitleThree.setText("Update admin");
                                changeBtnColor();
                                btnThreeBg();

                                btnTitleTwo.setVisible(true);
                                btnTitleThree.setVisible(true);
//                                hideMyForms();
//                                updateAdmin = new UpdateAdmin();
//                                desktopPane.add(updateAdmin);
//                                updateAdmin.displayInfo(uName, userId);
//                                updateAdmin.setVisible(true);
//                                try {
//                                    updateAdmin.setMaximum(true);
//                                } catch (Exception ex) {
//
//                                }
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                }
                box.setOpaque(true);
                box.setBackground(Color.WHITE);
                box.setOpaque(true);
                box.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(box);

                subAdminForm.add(sp, BorderLayout.CENTER);
                subAdminForm.pack();
                subAdminForm.setOpaque(false);
                subAdminForm.getContentPane().setBackground(Color.WHITE);
                subAdminForm.setSize(764, 562);
                subAdminForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = subAdminForm.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
                subAdminForm.setVisible(true);
                desktopPane.add(subAdminForm);
                subAdminForm.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }

    // For our OurProducts Form
    public void showOurProducts() {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading Products ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                OurProducts = new JInternalFrame();

                productServices = new ProductServices();
                List<Product> vectorProductDetail = productServices.getProductDetail();

                JPanel container = new JPanel();

                container.setBackground(Color.WHITE);
                //container.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(155, 0, 0)));

                BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(layout1);

                for (int i = 0; i < vectorProductDetail.size(); i++) {
                    JPanel top = new JPanel();
                    top.setBackground(Color.WHITE);
                    top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layout = new DesignGridLayout(top);

                    JLabel lblCode = new JLabel("Code");
                    JLabel lblSku = new JLabel("SKU");
                    JLabel lblQuantity = new JLabel("Quantity");
                    JLabel lblPurchasePrice = new JLabel("Purchase Amount");
                    lblPurchasePrice.setForeground(new Color(153, 0, 0));
                    JLabel lblSalePrice = new JLabel("Sale Amount");
                    lblPurchasePrice.setForeground(new Color(153, 0, 0));

                    JLabel lblProdNameVal = new JLabel(vectorProductDetail.get(i).getProName());
                    lblProdNameVal.setForeground(new Color(153, 0, 0));
                    JLabel lblCodeVal = new JLabel(vectorProductDetail.get(i).getProCode());
                    lblCodeVal.setForeground(new Color(165, 165, 165));
                    JLabel lblSkuVal = new JLabel(vectorProductDetail.get(i).getProSku());
                    lblSkuVal.setForeground(new Color(165, 165, 165));
                    JLabel lblQuantityVal = new JLabel(vectorProductDetail.get(i).getProQuantity());
                    lblQuantityVal.setForeground(new Color(165, 165, 165));
                    JLabel lblPurchasePriceVal = new JLabel(vectorProductDetail.get(i).getPurchasePrice());
                    lblPurchasePriceVal.setForeground(new Color(165, 165, 165));
                    JLabel lblSalePriceVal = new JLabel(vectorProductDetail.get(i).getSalePrice());
                    lblSalePriceVal.setForeground(new Color(165, 165, 165));

                    layout.row().grid().add(lblProdNameVal);
                    layout.row().grid().add(lblCode).add(lblQuantity).add(lblPurchasePrice);
                    layout.row().grid().add(lblCodeVal).add(lblQuantityVal).add(lblPurchasePriceVal);
                    layout.row().grid().add(lblSku).add(new JLabel("")).add(lblSalePrice);
                    layout.row().grid().add(lblSkuVal).add(new JLabel("")).add(lblSalePriceVal);

                    container.add(top);

                    top.setOpaque(true);
                    top.setBackground(Color.WHITE);
                }
                container.setOpaque(true);
                container.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(container);
                Dimension d = new Dimension(10, 10);
                sp.getVerticalScrollBar().setUnitIncrement(10);
                d.height *= 10;
                sp.getViewport().setPreferredSize(d);

                OurProducts.add(sp, BorderLayout.CENTER);
                OurProducts.pack();
                OurProducts.setOpaque(false);
                OurProducts.getContentPane().setBackground(Color.WHITE);
                OurProducts.setSize(764, 562);
                OurProducts.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = OurProducts.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

                OurProducts.setVisible(true);
                OurProducts.setBackground(Color.WHITE);
                desktopPane.add(OurProducts);
                OurProducts.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }
    
    // for single account detail
    
        public void showSingleAccHolderDetails(String accHolderId) {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading data ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                singleAccountHlderDetail = new JInternalFrame();

                accountServices = new AccountServices();
                
               List<AccountDetail> vectorAccountDetail = accountServices.getVectorAccountDetail(accHolderId);
               String name,mobileNum,address;
               AccountHolder accountHolder = accountServices.getAllById(accHolderId);
               name = accountHolder.getName();
               mobileNum = accountHolder.getMobileNum();
               address = accountHolder.getAddress();
               
                JPanel container = new JPanel();
                container.setBackground(Color.WHITE);

                JButton btnUpdate, btnDelete;

                BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(layout1);
                /////////////////////////////////////////////////////////////////////////
                JPanel topUpper = new JPanel();
                    topUpper.setBackground(new Color(248, 230, 230));
                    topUpper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layoutUpper = new DesignGridLayout(topUpper);
                    
                    JLabel lblName = new JLabel("Name");
                    JLabel lblMobile = new JLabel("Mobile No.");
                    JLabel lblAddress = new JLabel("Address");
                
                    lblName.setForeground(new Color(153, 0, 0));
                     lblMobile.setForeground(new Color(153, 0, 0));
                    lblAddress.setForeground(new Color(153, 0, 0));

                    JLabel lblNameVal = new JLabel(accountHolder.getName());
                    lblNameVal.setForeground(new Color(165, 165, 165));
                    JLabel lblMobileVal = new JLabel(accountHolder.getMobileNum());
                    lblMobileVal.setForeground(new Color(165, 165, 165));
                    JLabel lblAddressVal = new JLabel("<html><table><tr><td width='200'>" + accountHolder.getAddress() + "</td></tr></table></html>");
                    lblAddressVal.setForeground(new Color(165, 165, 165));
                    
                    JLabel lblTotalClosind = new JLabel("Name");
                    JLabel lblTotalCredit = new JLabel("Mobile No.");
                    JLabel lblTotalDebit = new JLabel("Address");
                
                    lblTotalClosind.setForeground(new Color(153, 0, 0));
                     lblTotalCredit.setForeground(new Color(153, 0, 0));
                    lblTotalDebit.setForeground(new Color(153, 0, 0));

                    JLabel lblTotalCreditVal = new JLabel(accountHolder.getTotalAccountDetail().getTotalCredit());
                    lblTotalCreditVal.setForeground(new Color(165, 165, 165));
                    JLabel lblTotalDebitVal = new JLabel(accountHolder.getTotalAccountDetail().getTotalDebit());
                    lblTotalDebitVal.setForeground(new Color(165, 165, 165));
                    JLabel lblTotalClosindVal = new JLabel(accountHolder.getTotalAccountDetail().getTotalClosing());
                    lblTotalClosindVal.setForeground(new Color(165, 165, 165));
            
                    layoutUpper.row().grid().add(lblName).add(lblMobile).add(lblAddress);
                    layoutUpper.row().grid().add(lblNameVal).add(lblMobileVal).add(lblAddressVal);
                    
                    layoutUpper.row().grid().add(lblTotalCredit).add(lblTotalDebit).add(lblTotalClosind);
                    layoutUpper.row().grid().add(lblTotalCreditVal).add(lblTotalDebitVal).add(lblTotalClosindVal);
       
                    container.add(topUpper);
                    
                    
                    ////////////////////////////////////////////////////////////////////////////
   
                for (int i = 0; i < vectorAccountDetail.size(); i++) {
                    JPanel top = new JPanel();
                    top.setBackground(Color.WHITE);
                    top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layout = new DesignGridLayout(top);

                    btnUpdate = new JButton("Update");
                    btnDelete = new JButton("Delete");
              

                    btnUpdate.setBackground(new Color(153, 0, 0));
                    btnDelete.setBackground(new Color(153, 0, 0));
               

                    btnUpdate.setPreferredSize(new Dimension(80, 40));
                    btnDelete.setPreferredSize(new Dimension(80, 40));
            
                    btnUpdate.setForeground(Color.WHITE);
                    btnDelete.setForeground(Color.WHITE);

                    JPanel pnlDelete = new JPanel();
                    pnlDelete.add(btnDelete);
                    pnlDelete.setBackground(Color.WHITE);

                    JPanel pnlUpdate = new JPanel();
                    pnlUpdate.add(btnUpdate);
                    pnlUpdate.setBackground(Color.WHITE);

                    JLabel lblCredit = new JLabel("Credit");
                    JLabel lblDebit = new JLabel("Debit");
                    JLabel lblClosing = new JLabel("Closing");
                    JLabel lblDate = new JLabel("Date");
                    JLabel lblDetail = new JLabel("Detail");
                
                    lblCredit.setForeground(new Color(153, 0, 0));
                     lblDebit.setForeground(new Color(153, 0, 0));
                    lblClosing.setForeground(new Color(153, 0, 0));

                    btnDelete.putClientProperty("id", vectorAccountDetail.get(i).getId());

                    btnUpdate.putClientProperty("id", vectorAccountDetail.get(i).getId());
                    btnUpdate.putClientProperty("Credit", vectorAccountDetail.get(i).getCredit());
                    //btnUpdate.putClientProperty("model", vectorProductDetail.get(i).getProModel());
                    btnUpdate.putClientProperty("Debit", vectorAccountDetail.get(i).getDebit());
                    btnUpdate.putClientProperty("Closing", vectorAccountDetail.get(i).getClosing());
                    btnUpdate.putClientProperty("Date", vectorAccountDetail.get(i).getDate());
                    btnUpdate.putClientProperty("Detail", vectorAccountDetail.get(i).getDetail());
         

                    JLabel lblCreditVal = new JLabel(vectorAccountDetail.get(i).getCredit());
                    lblCreditVal.setForeground(new Color(165, 165, 165));
                    JLabel lblDebitVal = new JLabel(vectorAccountDetail.get(i).getDebit());
                    lblDebitVal.setForeground(new Color(165, 165, 165));
                    JLabel lblClosingVal = new JLabel(vectorAccountDetail.get(i).getClosing());
                    lblClosingVal.setForeground(new Color(165, 165, 165));
                    
                    //JLabel lbllblDetailVal = new JLabel(vectorAccountDetail.get(i).getDetail());
                    JLabel lbllblDetailVal = new JLabel("<html><table><tr><td width='200'>" + vectorAccountDetail.get(i).getDetail() + "</td></tr></table></html>");
                    lbllblDetailVal.setForeground(new Color(165, 165, 165));
                    JLabel lbllblDateVal = new JLabel(vectorAccountDetail.get(i).getDate());
                    lbllblDateVal.setForeground(new Color(165, 165, 165));


                    //layout.row().grid().add(lblProdNameVal);
                    layout.row().grid().add(lblCredit).add(lblDebit).add(lblClosing).add(pnlUpdate);
                    layout.row().grid().add(lblCreditVal).add(lblDebitVal).add(lblClosingVal).add(pnlDelete);
                    layout.row().grid().add(lblDetail).add(lblDate);
                    layout.row().grid().add(lbllblDetailVal).add(lbllblDateVal);
       
                    container.add(top);

                    top.setOpaque(true);
                    top.setBackground(Color.WHITE);

                    btnDelete.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object command = ((JButton) e.getSource()).getClientProperty("id");
                                String productId = command.toString();
                                boolean status = accountServices.deleteAccountLedgerDetail(productId);
                                if (status == true) {
                                    JOptionPane.showMessageDialog(null, "Data deleted sucessfully");
                                    hideMyForms();
                                    showSingleAccHolderDetails(accHolderId);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Data not deleted");
                                }
                            }
                        }
                    });


                    btnUpdate.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                    

                                Object id = ((JButton) e.getSource()).getClientProperty("id");
                                Object credit = ((JButton) e.getSource()).getClientProperty("Credit");
                                Object debit = ((JButton) e.getSource()).getClientProperty("Debit");
                                Object closing = ((JButton) e.getSource()).getClientProperty("Closing");
                                Object date = ((JButton) e.getSource()).getClientProperty("Date");
                                Object detail = ((JButton) e.getSource()).getClientProperty("Detail");

                                String myId = id.toString();
                                String mycredit = credit.toString();
                                String mydebit = debit.toString();
                                String myclosing = closing.toString();
                                String mydate = date.toString();
                                String mydetail = detail.toString();

                                btnTitleThree.setText("Update Record");
                                changeBtnColor();
                                btnThreeBg();

                                btnTitleTwo.setVisible(true);
                                btnTitleThree.setVisible(true);
                                hideMyForms();
                                ledgerUpdateForm = new LedgerUpdateForm();
                                desktopPane.add(ledgerUpdateForm);
                                ledgerUpdateForm.displayInfo(myId, mycredit, mydebit, myclosing, mydate, mydetail, name,mobileNum,address);
                                ledgerUpdateForm.setVisible(true);
                                try {
                                    ledgerUpdateForm.setMaximum(true);
                                } catch (Exception ex) {
                                }
                            }
                        }
                    });
                }
          
                container.setOpaque(true);
                container.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(container);
                Dimension d = new Dimension(10, 10);
                sp.getVerticalScrollBar().setUnitIncrement(10);
                d.height *= 10;
                sp.getViewport().setPreferredSize(d);
                singleAccountHlderDetail.add(sp, BorderLayout.CENTER);
                singleAccountHlderDetail.pack();
                singleAccountHlderDetail.setOpaque(false);
                singleAccountHlderDetail.getContentPane().setBackground(Color.WHITE);
                singleAccountHlderDetail.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = singleAccountHlderDetail.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

                singleAccountHlderDetail.setVisible(true);
                desktopPane.add(singleAccountHlderDetail);
                singleAccountHlderDetail.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }
        
public void showAllTotalDetails() {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading data ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                allTotalDetailForm = new JInternalFrame();

                accountServices = new AccountServices();
                Vector<AccountHolder> vectorDailyDetail = accountServices.getAll();

                JPanel container = new JPanel();
                container.setBackground(Color.WHITE);

                JButton btnUpdate, btnDelete;

                BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(layout1);
                /////////////////////////////////////////////////////////////////////////
                JPanel topUpper = new JPanel();
                topUpper.setBackground(new Color(248, 230, 230));
                topUpper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                DesignGridLayout layoutUpper = new DesignGridLayout(topUpper);

                JLabel lblDate = new JLabel("Date");
                JLabel lblTotalCredit = new JLabel("Total Credit");
                JLabel lblTotalDebit = new JLabel("Total Debit");
                JLabel lblTotalClosingBal = new JLabel("Total Closing Balance");

                lblTotalCredit.setForeground(new Color(153, 0, 0));
                lblTotalDebit.setForeground(new Color(153, 0, 0));
                lblTotalClosingBal.setForeground(new Color(153, 0, 0));
                
                String date = "";
                String totalCredit = "";
                String totalDebit = "";
                String totalClosing = "";

                JLabel lblDateVal = new JLabel(date);
                lblDateVal.setForeground(new Color(165, 165, 165));
                JLabel lbltotalCreditVal = new JLabel(totalCredit);
                lbltotalCreditVal.setForeground(new Color(165, 165, 165));
                JLabel lblDebitVal = new JLabel(totalDebit);
                lblDebitVal.setForeground(new Color(165, 165, 165));
                JLabel lblClosingVal = new JLabel(totalClosing);
                lblClosingVal.setForeground(new Color(165, 165, 165));

                layoutUpper.row().grid().add(lblDate).add(lblTotalCredit).add(lblTotalDebit).add(lblTotalClosingBal);
                layoutUpper.row().grid().add(lblDateVal).add(lbltotalCreditVal).add(lblDebitVal).add(lblClosingVal);

                container.add(topUpper);

                    ////////////////////////////////////////////////////////////////////////////
                for (int i = 0; i < vectorDailyDetail.size(); i++) {
                    JPanel top = new JPanel();
                    top.setBackground(Color.WHITE);
                    top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layout = new DesignGridLayout(top);

//                    btnUpdate = new JButton("Update");
                    btnDelete = new JButton("Delete");
//              
//
//                    btnUpdate.setBackground(new Color(153, 0, 0));
                    btnDelete.setBackground(new Color(153, 0, 0));
//               
//
//                    btnUpdate.setPreferredSize(new Dimension(80, 40));
                    btnDelete.setPreferredSize(new Dimension(80, 40));
//            
//                    btnUpdate.setForeground(Color.WHITE);
                    btnDelete.setForeground(Color.WHITE);

                    JPanel pnlDelete = new JPanel();
                    pnlDelete.add(btnDelete);
                    pnlDelete.setBackground(Color.WHITE);
//
//                    JPanel pnlUpdate = new JPanel();
//                    pnlUpdate.add(btnUpdate);
//                    pnlUpdate.setBackground(Color.WHITE);
                    JLabel lblName = new JLabel("Name");
                    JLabel lblMobileNum = new JLabel("Mobile No.");
                    JLabel lblAddress = new JLabel("Address");

                    JLabel lblCredit = new JLabel("Credit");
                    JLabel lblDebit = new JLabel("Debit");
                    JLabel lblClosing = new JLabel("Closing");

                    lblCredit.setForeground(new Color(153, 0, 0));
                    lblDebit.setForeground(new Color(153, 0, 0));
                    lblClosing.setForeground(new Color(153, 0, 0));

                    btnDelete.putClientProperty("id", vectorDailyDetail.get(i).getAccountDetail().getId());
//                    btnUpdate.putClientProperty("id", vectorDailyDetail.get(i).getAccountDetail().getId());
//                    btnUpdate.putClientProperty("Credit", vectorAccountDetail.get(i).getCredit());
//                    //btnUpdate.putClientProperty("model", vectorProductDetail.get(i).getProModel());
//                    btnUpdate.putClientProperty("Debit", vectorAccountDetail.get(i).getDebit());
//                    btnUpdate.putClientProperty("Closing", vectorAccountDetail.get(i).getClosing());
//                    btnUpdate.putClientProperty("Date", vectorAccountDetail.get(i).getDate());
//                    btnUpdate.putClientProperty("Detail", vectorAccountDetail.get(i).getDetail());
                    JLabel lblNameValOne = new JLabel(vectorDailyDetail.get(i).getName());
                    lblNameValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblMobileNumValOne = new JLabel(vectorDailyDetail.get(i).getMobileNum());
                    lblMobileNumValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblAddressValOne = new JLabel(vectorDailyDetail.get(i).getAddress());
                    lblAddressValOne.setForeground(new Color(165, 165, 165));

                    JLabel lblCreditValOne = new JLabel(vectorDailyDetail.get(i).getTotalAccountDetail().getTotalCredit());
                    lblCreditValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblDebitValOne = new JLabel(vectorDailyDetail.get(i).getTotalAccountDetail().getTotalDebit());
                    lblDebitValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblClosingValOne = new JLabel(vectorDailyDetail.get(i).getTotalAccountDetail().getTotalClosing());
                    lblClosingValOne.setForeground(new Color(165, 165, 165));


                    layout.row().grid().add(lblName).add(lblMobileNum).add(pnlDelete);
                    layout.row().grid().add(lblNameValOne).add(lblMobileNumValOne);
                    layout.row().grid().add(lblAddress);
                    layout.row().grid().add(lblAddressValOne);

                    layout.row().grid().add(lblCredit).add(lblDebit).add(lblClosing);
                    layout.row().grid().add(lblCreditValOne).add(lblDebitValOne).add(lblClosingValOne);
      

                    container.add(top);

                    top.setOpaque(true);
                    top.setBackground(Color.WHITE);

                    btnDelete.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to view more detail?", "Message", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object command = ((JButton) e.getSource()).getClientProperty("id");
                                String accountHolderId = command.toString();
                                
                                 btnTitleThree.setText("More Detail");
                                changeBtnColor();
                                btnThreeBg();
                                btnTitleThree.setVisible(true);
                                hideMyForms();
                                
                                showSingleAccHolderDetails(accountHolderId);
                                
                            }
                        }
                    });
//
//
//                    btnUpdate.addActionListener(new ActionListener() {
//
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            int dialogButton = JOptionPane.YES_NO_OPTION;
//                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Warning", dialogButton);
//                            if (dialogResult == JOptionPane.YES_OPTION) {
//                    
//
//                                Object id = ((JButton) e.getSource()).getClientProperty("id");
//                                Object credit = ((JButton) e.getSource()).getClientProperty("Credit");
//                                Object debit = ((JButton) e.getSource()).getClientProperty("Debit");
//                                Object closing = ((JButton) e.getSource()).getClientProperty("Closing");
//                                Object date = ((JButton) e.getSource()).getClientProperty("Date");
//                                Object detail = ((JButton) e.getSource()).getClientProperty("Detail");
//
//                                String myId = id.toString();
//                                String mycredit = credit.toString();
//                                String mydebit = debit.toString();
//                                String myclosing = closing.toString();
//                                String mydate = date.toString();
//                                String mydetail = detail.toString();
//
//                                btnTitleThree.setText("Update Record");
//                                changeBtnColor();
//                                btnThreeBg();
//
//                                btnTitleTwo.setVisible(true);
//                                btnTitleThree.setVisible(true);
//                                hideMyForms();
//                                ledgerUpdateForm = new LedgerUpdateForm();
//                                desktopPane.add(ledgerUpdateForm);
//                                ledgerUpdateForm.displayInfo(myId, mycredit, mydebit, myclosing, mydate, mydetail, name,mobileNum,address);
//                                ledgerUpdateForm.setVisible(true);
//                                try {
//                                    ledgerUpdateForm.setMaximum(true);
//                                } catch (Exception ex) {
//                                }
//                            }
//                        }
//                    });
                }

                container.setOpaque(true);
                container.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(container);
                Dimension d = new Dimension(10, 10);
                sp.getVerticalScrollBar().setUnitIncrement(10);
                d.height *= 10;
                sp.getViewport().setPreferredSize(d);
                allTotalDetailForm.add(sp, BorderLayout.CENTER);
                allTotalDetailForm.pack();
                allTotalDetailForm.setOpaque(false);
                allTotalDetailForm.getContentPane().setBackground(Color.WHITE);
                allTotalDetailForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = allTotalDetailForm.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

                allTotalDetailForm.setVisible(true);
                desktopPane.add(allTotalDetailForm);
                allTotalDetailForm.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }
        
        // for daily detail
     public void showDailyLedgerDetails(String totalCredit, String totalDebit, String totalClosing, String date) {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading data ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                LegerDailyDetailForm = new JInternalFrame();

                accountServices = new AccountServices();
                Vector<AccountHolder> vectorDailyDetail = accountServices.getVectorAccountHolderAllDetByDate(date);

                JPanel container = new JPanel();
                container.setBackground(Color.WHITE);

                JButton btnUpdate, btnDelete;

                BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(layout1);
                /////////////////////////////////////////////////////////////////////////
                JPanel topUpper = new JPanel();
                topUpper.setBackground(new Color(248, 230, 230));
                topUpper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                DesignGridLayout layoutUpper = new DesignGridLayout(topUpper);

                JLabel lblDate = new JLabel("Date");
                JLabel lblTotalCredit = new JLabel("Total Credit");
                JLabel lblTotalDebit = new JLabel("Total Debit");
                JLabel lblTotalClosingBal = new JLabel("Total Closing Balance");

                lblTotalCredit.setForeground(new Color(153, 0, 0));
                lblTotalDebit.setForeground(new Color(153, 0, 0));
                lblTotalClosingBal.setForeground(new Color(153, 0, 0));

                JLabel lblDateVal = new JLabel(date);
                lblDateVal.setForeground(new Color(165, 165, 165));
                JLabel lbltotalCreditVal = new JLabel(totalCredit);
                lbltotalCreditVal.setForeground(new Color(165, 165, 165));
                JLabel lblDebitVal = new JLabel(totalDebit);
                lblDebitVal.setForeground(new Color(165, 165, 165));
                JLabel lblClosingVal = new JLabel(totalClosing);
                lblClosingVal.setForeground(new Color(165, 165, 165));

                layoutUpper.row().grid().add(lblDate).add(lblTotalCredit).add(lblTotalDebit).add(lblTotalClosingBal);
                layoutUpper.row().grid().add(lblDateVal).add(lbltotalCreditVal).add(lblDebitVal).add(lblClosingVal);

                container.add(topUpper);

                    ////////////////////////////////////////////////////////////////////////////
                for (int i = 0; i < vectorDailyDetail.size(); i++) {
                    JPanel top = new JPanel();
                    top.setBackground(Color.WHITE);
                    top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layout = new DesignGridLayout(top);

//                    btnUpdate = new JButton("Update");
//                    btnDelete = new JButton("Delete");
//              
//
//                    btnUpdate.setBackground(new Color(153, 0, 0));
//                    btnDelete.setBackground(new Color(153, 0, 0));
//               
//
//                    btnUpdate.setPreferredSize(new Dimension(80, 40));
//                    btnDelete.setPreferredSize(new Dimension(80, 40));
//            
//                    btnUpdate.setForeground(Color.WHITE);
//                    btnDelete.setForeground(Color.WHITE);
//
//                    JPanel pnlDelete = new JPanel();
//                    pnlDelete.add(btnDelete);
//                    pnlDelete.setBackground(Color.WHITE);
//
//                    JPanel pnlUpdate = new JPanel();
//                    pnlUpdate.add(btnUpdate);
//                    pnlUpdate.setBackground(Color.WHITE);
                    JLabel lblName = new JLabel("Name");
                    JLabel lblMobileNum = new JLabel("Mobile No.");
                    JLabel lblAddress = new JLabel("Address");

                    JLabel lblCredit = new JLabel("Credit");
                    JLabel lblDebit = new JLabel("Debit");
                    JLabel lblClosing = new JLabel("Closing");
                    JLabel lblDetail = new JLabel("Detail");

                    lblCredit.setForeground(new Color(153, 0, 0));
                    lblDebit.setForeground(new Color(153, 0, 0));
                    lblClosing.setForeground(new Color(153, 0, 0));

  //                  btnDelete.putClientProperty("id", vectorDailyDetail.get(i).getAccountDetail().getId());
//                    btnUpdate.putClientProperty("id", vectorDailyDetail.get(i).getAccountDetail().getId());
//                    btnUpdate.putClientProperty("Credit", vectorAccountDetail.get(i).getCredit());
//                    //btnUpdate.putClientProperty("model", vectorProductDetail.get(i).getProModel());
//                    btnUpdate.putClientProperty("Debit", vectorAccountDetail.get(i).getDebit());
//                    btnUpdate.putClientProperty("Closing", vectorAccountDetail.get(i).getClosing());
//                    btnUpdate.putClientProperty("Date", vectorAccountDetail.get(i).getDate());
//                    btnUpdate.putClientProperty("Detail", vectorAccountDetail.get(i).getDetail());
                    JLabel lblNameValOne = new JLabel(vectorDailyDetail.get(i).getName());
                    lblNameValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblMobileNumValOne = new JLabel(vectorDailyDetail.get(i).getMobileNum());
                    lblMobileNumValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblAddressValOne = new JLabel(vectorDailyDetail.get(i).getAddress());
                    lblAddressValOne.setForeground(new Color(165, 165, 165));

                    JLabel lblCreditValOne = new JLabel(vectorDailyDetail.get(i).getAccountDetail().getCredit());
                    lblCreditValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblDebitValOne = new JLabel(vectorDailyDetail.get(i).getAccountDetail().getDebit());
                    lblDebitValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblClosingValOne = new JLabel(vectorDailyDetail.get(i).getAccountDetail().getClosing());
                    lblClosingValOne.setForeground(new Color(165, 165, 165));

                    //JLabel lbllblDetailVal = new JLabel(vectorAccountDetail.get(i).getDetail());
                    JLabel lbllblDetailVal = new JLabel("<html><table><tr><td width='200'>" + vectorDailyDetail.get(i).getAccountDetail().getDetail() + "</td></tr></table></html>");
                    lbllblDetailVal.setForeground(new Color(165, 165, 165));

                    layout.row().grid().add(lblName).add(lblMobileNum);
                    layout.row().grid().add(lblNameValOne).add(lblMobileNumValOne);
                    layout.row().grid().add(lblAddress);
                    layout.row().grid().add(lblAddressValOne);

                    layout.row().grid().add(lblCredit).add(lblDebit).add(lblClosing);
                    layout.row().grid().add(lblCreditValOne).add(lblDebitValOne).add(lblClosingValOne);
                    layout.row().grid().add(lblDetail);
                    layout.row().grid().add(lbllblDetailVal);

                    container.add(top);

                    top.setOpaque(true);
                    top.setBackground(Color.WHITE);

//                    btnDelete.addActionListener(new ActionListener() {
//
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            int dialogButton = JOptionPane.YES_NO_OPTION;
//                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning", dialogButton);
//                            if (dialogResult == JOptionPane.YES_OPTION) {
//                                Object command = ((JButton) e.getSource()).getClientProperty("id");
//                                String productId = command.toString();
//                                boolean status = accountServices.deleteAccountLedgerDetail(productId);
//                                if (status == true) {
//                                    JOptionPane.showMessageDialog(null, "Data deleted sucessfully");
//                                    hideMyForms();
//                                    showSingleAccHolderDetails(accHolderId,name,mobileNum,address);
//
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Data not deleted");
//                                }
//                            }
//                        }
//                    });
//
//
//                    btnUpdate.addActionListener(new ActionListener() {
//
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            int dialogButton = JOptionPane.YES_NO_OPTION;
//                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Warning", dialogButton);
//                            if (dialogResult == JOptionPane.YES_OPTION) {
//                    
//
//                                Object id = ((JButton) e.getSource()).getClientProperty("id");
//                                Object credit = ((JButton) e.getSource()).getClientProperty("Credit");
//                                Object debit = ((JButton) e.getSource()).getClientProperty("Debit");
//                                Object closing = ((JButton) e.getSource()).getClientProperty("Closing");
//                                Object date = ((JButton) e.getSource()).getClientProperty("Date");
//                                Object detail = ((JButton) e.getSource()).getClientProperty("Detail");
//
//                                String myId = id.toString();
//                                String mycredit = credit.toString();
//                                String mydebit = debit.toString();
//                                String myclosing = closing.toString();
//                                String mydate = date.toString();
//                                String mydetail = detail.toString();
//
//                                btnTitleThree.setText("Update Record");
//                                changeBtnColor();
//                                btnThreeBg();
//
//                                btnTitleTwo.setVisible(true);
//                                btnTitleThree.setVisible(true);
//                                hideMyForms();
//                                ledgerUpdateForm = new LedgerUpdateForm();
//                                desktopPane.add(ledgerUpdateForm);
//                                ledgerUpdateForm.displayInfo(myId, mycredit, mydebit, myclosing, mydate, mydetail, name,mobileNum,address);
//                                ledgerUpdateForm.setVisible(true);
//                                try {
//                                    ledgerUpdateForm.setMaximum(true);
//                                } catch (Exception ex) {
//                                }
//                            }
//                        }
//                    });
                }

                container.setOpaque(true);
                container.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(container);
                Dimension d = new Dimension(10, 10);
                sp.getVerticalScrollBar().setUnitIncrement(10);
                d.height *= 10;
                sp.getViewport().setPreferredSize(d);
                LegerDailyDetailForm.add(sp, BorderLayout.CENTER);
                LegerDailyDetailForm.pack();
                LegerDailyDetailForm.setOpaque(false);
                LegerDailyDetailForm.getContentPane().setBackground(Color.WHITE);
                LegerDailyDetailForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = LegerDailyDetailForm.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

                LegerDailyDetailForm.setVisible(true);
                desktopPane.add(LegerDailyDetailForm);
                LegerDailyDetailForm.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }
    
        public void showLedgerDetailsBtnDates(String totalCredit,String totalDebit,int totalClosing,String fromDate,String toDate) {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading data ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                btnDatesForm = new JInternalFrame();

                accountServices = new AccountServices();
                Vector<AccountHolder> vectorDailyDetail = accountServices.getVectorAccountHolderAllDetBtwDate(fromDate, toDate);
               
                JPanel container = new JPanel();
                container.setBackground(Color.WHITE);

                BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(layout1);
                /////////////////////////////////////////////////////////////////////////
                JPanel topUpper = new JPanel();
                    topUpper.setBackground(new Color(248, 230, 230));
                    topUpper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layoutUpper = new DesignGridLayout(topUpper);
                    
                    JLabel lblFromDate = new JLabel("From Date");
                    JLabel lblToDate = new JLabel("To Date");
                    JLabel lblTotalCredit = new JLabel("Total Credit");
                    JLabel lblTotalDebit = new JLabel("Total Debit");
                    JLabel lblTotalClosingBal = new JLabel("Total Closing Balance");
                
                    lblTotalCredit.setForeground(new Color(153, 0, 0));
                     lblTotalDebit.setForeground(new Color(153, 0, 0));
                    lblTotalClosingBal.setForeground(new Color(153, 0, 0));

                    JLabel lblFromDateVal = new JLabel(fromDate);
                    lblFromDateVal.setForeground(new Color(165, 165, 165));
                    JLabel lblToDateVal = new JLabel(toDate);
                    lblToDateVal.setForeground(new Color(165, 165, 165));
                    JLabel lbltotalCreditVal = new JLabel(totalCredit);
                    lbltotalCreditVal.setForeground(new Color(165, 165, 165));
                    JLabel lblDebitVal = new JLabel(totalDebit);
                    lblDebitVal.setForeground(new Color(165, 165, 165));
                    JLabel lblClosingVal = new JLabel(totalClosing+"");
                    lblClosingVal.setForeground(new Color(165, 165, 165));
            
                layoutUpper.row().grid().add(lblFromDate).add(lblToDate);
                layoutUpper.row().grid().add(lblFromDateVal).add(lblToDateVal);
                layoutUpper.row().grid().add(lblTotalCredit).add(lblTotalDebit).add(lblTotalClosingBal);
                layoutUpper.row().grid().add(lbltotalCreditVal).add(lblDebitVal).add(lblClosingVal);

                container.add(topUpper);
                    
                    
                    ////////////////////////////////////////////////////////////////////////////
   
                for (int i = 0; i < vectorDailyDetail.size(); i++) {
                    JPanel top = new JPanel();
                    top.setBackground(Color.WHITE);
                    top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layout = new DesignGridLayout(top);
                    
                    JLabel lblName = new JLabel("Name");
                    JLabel lblMobileNum = new JLabel("Mobile No.");
                    JLabel lblAddress = new JLabel("Address");
              

                    JLabel lblCredit = new JLabel("Credit");
                    JLabel lblDebit = new JLabel("Debit");
                    JLabel lblClosing = new JLabel("Closing");
                    JLabel lblDetail = new JLabel("Detail");
                
                    lblCredit.setForeground(new Color(153, 0, 0));
                     lblDebit.setForeground(new Color(153, 0, 0));
                    lblClosing.setForeground(new Color(153, 0, 0));
         
                    JLabel lblNameValOne = new JLabel(vectorDailyDetail.get(i).getName());
                    lblNameValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblMobileNumValOne = new JLabel(vectorDailyDetail.get(i).getMobileNum());
                    lblMobileNumValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblAddressValOne = new JLabel(vectorDailyDetail.get(i).getAddress());
                    lblAddressValOne.setForeground(new Color(165, 165, 165));

                    JLabel lblCreditValOne = new JLabel(vectorDailyDetail.get(i).getAccountDetail().getCredit());
                    lblCreditValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblDebitValOne = new JLabel(vectorDailyDetail.get(i).getAccountDetail().getDebit());
                    lblDebitValOne.setForeground(new Color(165, 165, 165));
                    JLabel lblClosingValOne = new JLabel(vectorDailyDetail.get(i).getAccountDetail().getClosing());
                    lblClosingValOne.setForeground(new Color(165, 165, 165));
                    
                    //JLabel lbllblDetailVal = new JLabel(vectorAccountDetail.get(i).getDetail());
                    JLabel lbllblDetailVal = new JLabel("<html><table><tr><td width='400'>" + vectorDailyDetail.get(i).getAccountDetail().getDetail()+ "</td></tr></table></html>");
                    lbllblDetailVal.setForeground(new Color(165, 165, 165));
              


                    layout.row().grid().add(lblName).add(lblMobileNum);
                    layout.row().grid().add(lblNameValOne).add(lblMobileNumValOne);
                    layout.row().grid().add(lblAddress);
                    layout.row().grid().add(lblAddressValOne);
                    
                    layout.row().grid().add(lblCredit).add(lblDebit).add(lblClosing);
                    layout.row().grid().add(lblCreditValOne).add(lblDebitValOne).add(lblClosingValOne);
                    layout.row().grid().add(lblDetail);
                    layout.row().grid().add(lbllblDetailVal);
       
                    container.add(top);

                    top.setOpaque(true);
                    top.setBackground(Color.WHITE);

                }
          
                container.setOpaque(true);
                container.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(container);
                Dimension d = new Dimension(10, 10);
                sp.getVerticalScrollBar().setUnitIncrement(10);
                d.height *= 10;
                sp.getViewport().setPreferredSize(d);
                btnDatesForm.add(sp, BorderLayout.CENTER);
                btnDatesForm.pack();
                btnDatesForm.setOpaque(false);
                btnDatesForm.getContentPane().setBackground(Color.WHITE);
                btnDatesForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = btnDatesForm.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

                btnDatesForm.setVisible(true);
                desktopPane.add(btnDatesForm);
                btnDatesForm.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }

    // For our OurProducts Form
    public void showOurProductsAll() {

        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Loading Products ...........");
        lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWait.setForeground(new Color(191, 39, 38));
        JPanel panel1;
        panel1 = new JPanel(new BorderLayout(5, 5));
        panel1.setBackground(Color.WHITE);
        panel1.add(lblWait, BorderLayout.PAGE_START);
        panel1.add(lblAnimation, BorderLayout.CENTER);

        panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel1);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, 180);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialog.dispose();
            }

            @Override
            protected void process(List chunks) {

            }

            @Override
            protected Object doInBackground() throws Exception {

                ourProductsAll = new JInternalFrame();

                productServices = new ProductServices();
                List<Product> vectorProductDetail = productServices.getProductDetail();

                JPanel container = new JPanel();
                container.setBackground(Color.WHITE);

                JButton btnUpdate, btnDelete, btnEdit, btnSeo;

                BoxLayout layout1 = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(layout1);

                for (int i = 0; i < vectorProductDetail.size(); i++) {
                    JPanel top = new JPanel();
                    top.setBackground(Color.WHITE);
                    top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
                    DesignGridLayout layout = new DesignGridLayout(top);

                    btnUpdate = new JButton("Update");
                    btnDelete = new JButton("Delete");
                    btnEdit = new JButton("Edit");
                    btnSeo = new JButton("SEO");

                    btnUpdate.setBackground(new Color(153, 0, 0));
                    btnDelete.setBackground(new Color(153, 0, 0));
                    btnEdit.setBackground(new Color(153, 0, 0));
                    btnSeo.setBackground(new Color(153, 0, 0));

                    btnUpdate.setPreferredSize(new Dimension(80, 40));
                    btnDelete.setPreferredSize(new Dimension(80, 40));
                    btnEdit.setPreferredSize(new Dimension(80, 40));
                    btnSeo.setPreferredSize(new Dimension(80, 40));

                    btnUpdate.setForeground(Color.WHITE);
                    btnDelete.setForeground(Color.WHITE);
                    btnEdit.setForeground(Color.WHITE);
                    btnSeo.setForeground(Color.WHITE);

                    JPanel pnlDelete = new JPanel();
                    pnlDelete.add(btnDelete);
                    pnlDelete.setBackground(Color.WHITE);

                    JPanel pnlUpdate = new JPanel();
                    pnlUpdate.add(btnUpdate);
                    pnlUpdate.setBackground(Color.WHITE);

                    JPanel pnlEdit = new JPanel();
                    pnlEdit.add(btnEdit);
                    pnlEdit.setBackground(Color.WHITE);

                    JPanel pnlSeo = new JPanel();
                    pnlSeo.add(btnSeo);
                    pnlSeo.setBackground(Color.WHITE);

                    JLabel lblCode = new JLabel("Code");
                    JLabel lblSku = new JLabel("SKU");
                    JLabel lblQuantity = new JLabel("Quantity");
                    JLabel lblPurchasePrice = new JLabel("Purchase Amount");
                    lblPurchasePrice.setForeground(new Color(153, 0, 0));
                    JLabel lblSalePrice = new JLabel("Sale Amount");
                    lblSalePrice.setForeground(new Color(153, 0, 0));

                    btnDelete.putClientProperty("id", vectorProductDetail.get(i).getProId());

                    btnUpdate.putClientProperty("id", vectorProductDetail.get(i).getProId());
                    btnUpdate.putClientProperty("name", vectorProductDetail.get(i).getProName());
                    //btnUpdate.putClientProperty("model", vectorProductDetail.get(i).getProModel());
                    btnUpdate.putClientProperty("quantity", vectorProductDetail.get(i).getProQuantity());
                    btnUpdate.putClientProperty("sku", vectorProductDetail.get(i).getProSku());
                    btnUpdate.putClientProperty("pPrice", vectorProductDetail.get(i).getPurchasePrice());
                    btnUpdate.putClientProperty("sPrice", vectorProductDetail.get(i).getSalePrice());
                    btnUpdate.putClientProperty("code", vectorProductDetail.get(i).getProCode());
                    //btnUpdate.putClientProperty("desc", vectorProductDetail.get(i).getDesc());

                    btnEdit.putClientProperty("id", vectorProductDetail.get(i).getProId());
                    btnSeo.putClientProperty("id", vectorProductDetail.get(i).getProId());

                    JLabel lblProdNameVal = new JLabel(vectorProductDetail.get(i).getProName());
                    lblProdNameVal.setForeground(new Color(153, 0, 0));
                    JLabel lblCodeVal = new JLabel(vectorProductDetail.get(i).getProCode());
                    lblCodeVal.setForeground(new Color(165, 165, 165));
                    JLabel lblSkuVal = new JLabel(vectorProductDetail.get(i).getProSku());
                    lblSkuVal.setForeground(new Color(165, 165, 165));
                    JLabel lblQuantityVal = new JLabel(vectorProductDetail.get(i).getProQuantity());
                    lblQuantityVal.setForeground(new Color(165, 165, 165));
                    JLabel lblPurchasePriceVal = new JLabel(vectorProductDetail.get(i).getPurchasePrice());
                    lblPurchasePriceVal.setForeground(new Color(165, 165, 165));
                    JLabel lblSalePriceVal = new JLabel(vectorProductDetail.get(i).getSalePrice());
                    lblSalePriceVal.setForeground(new Color(165, 165, 165));

                    layout.row().grid().add(lblProdNameVal);
                    layout.row().grid().add(lblCode).add(lblQuantity).add(lblPurchasePrice).add(pnlUpdate);
                    layout.row().grid().add(lblCodeVal).add(lblQuantityVal).add(lblPurchasePriceVal).add(pnlDelete);
                    layout.row().grid().add(lblSku).add(new JLabel("")).add(lblSalePrice).add(pnlEdit);
                    layout.row().grid().add(lblSkuVal).add(new JLabel("")).add(lblSalePriceVal).add(pnlSeo);

                    container.add(top);

                    top.setOpaque(true);
                    top.setBackground(Color.WHITE);

                    btnDelete.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                Object command = ((JButton) e.getSource()).getClientProperty("id");
                                //System.out.println("the id is "+command.toString());
                                String productId = command.toString();
                                boolean status = productServices.deleteProduct(productId);
                                if (status == true) {
                                    JOptionPane.showMessageDialog(null, "Product deleted sucessfully");
                                    hideMyForms();
                                    showOurProductsAll();

                                } else {
                                    JOptionPane.showMessageDialog(null, "Product not deleted");
                                }
                            }
                        }
                    });

                    btnSeo.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Object proId = ((JButton) e.getSource()).getClientProperty("id");

                            String productId = proId.toString();

                            btnTitleThree.setText("Add SEO");

                            changeBtnColor();
                            btnThreeBg();

                            btnTitleThree.setVisible(true);
//                            hideMyForms();
//                            addSeoForm = new AddSeoForm();
//                            desktopPane.add(addSeoForm);
//                            addSeoForm.displayInfo(productId);
//                            addSeoForm.setVisible(true);
//                            try {
//                                addSeoForm.setMaximum(true);
//                            } catch (Exception ex) {
//                            }
                        }
                    });

                    btnEdit.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Object proId = ((JButton) e.getSource()).getClientProperty("id");

                            productId = proId.toString();

                            btnTitleTwo.setText("Edit Product");

                            changeBtnColor();
                            btnTwoBg();

                            btnTitleTwo.setVisible(true);
                            hideMyForms();
                            //showEditProductForm(productId);

                        }
                    });

                    btnUpdate.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {

                                Object id = ((JButton) e.getSource()).getClientProperty("id");
                                Object name = ((JButton) e.getSource()).getClientProperty("name");
                                Object quantity = ((JButton) e.getSource()).getClientProperty("quantity");
                                Object sku = ((JButton) e.getSource()).getClientProperty("sku");
                                //Object model = ((JButton) e.getSource()).getClientProperty("model");
                                Object code = ((JButton) e.getSource()).getClientProperty("code");
                                Object pPrice = ((JButton) e.getSource()).getClientProperty("pPrice");
                                Object sPrice = ((JButton) e.getSource()).getClientProperty("sPrice");
                                //Object desc = ((JButton) e.getSource()).getClientProperty("desc");

                                String pId = id.toString();
                                String pName = name.toString();
                                String pSku = sku.toString();
                                //String pModel = model.toString();
                                String pCode = code.toString();
                                String purPrice = pPrice.toString();
                                String pSalePrice = sPrice.toString();
                                String pQuantity = quantity.toString();
                                //String pDesc = desc.toString();

                                btnTitleTwo.setText("Update Product");
                                changeBtnColor();
                                btnTwoBg();

                                btnTitleTwo.setVisible(true);
//                                hideMyForms();
//                                updateProductForm = new UpdateProductForm();
//                                desktopPane.add(updateProductForm);
//                                updateProductForm.displayInfo(pId, pName, pSku, pCode, purPrice, pSalePrice, pQuantity);
//                                updateProductForm.setVisible(true);
//                                try {
//                                    updateProductForm.setMaximum(true);
//                                } catch (Exception ex) {
//                                }
                            }
                        }
                    });
                }
                container.setOpaque(true);
                container.setBackground(Color.WHITE);
                JScrollPane sp = new JScrollPane(container);
                Dimension d = new Dimension(10, 10);
                sp.getVerticalScrollBar().setUnitIncrement(10);
                d.height *= 10;
                sp.getViewport().setPreferredSize(d);

                ourProductsAll.add(sp, BorderLayout.CENTER);
                ourProductsAll.pack();
                ourProductsAll.setOpaque(false);
                ourProductsAll.getContentPane().setBackground(Color.WHITE);
                ourProductsAll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                javax.swing.plaf.InternalFrameUI ifu = ourProductsAll.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

                ourProductsAll.setVisible(true);
                desktopPane.add(ourProductsAll);
                ourProductsAll.setMaximum(true);

                return null;
            }
        };

        worker.execute();
    }
    

    public void hideMyForms() {
        //System.out.println("Hide callled");
       
        if (myAttributeValueForm != null) {
            myAttributeValueForm.dispose();
        }
        if (addProductForm != null) {
            addProductForm.dispose();
        }
        if (logoutForm != null) {
            logoutForm.dispose();
        }
        if (DeleteLogoForm != null) {
            DeleteLogoForm.dispose();
        }
        if (MySlidersForm != null) {
            MySlidersForm.dispose();
        }
        if (addAdmin != null) {
            addAdmin.dispose();
        }
        if (OurPagesForm != null) {
            OurPagesForm.dispose();
        }
        if (OurCategoryForm != null) {
            OurCategoryForm.dispose();
        }
        if (OurProducts != null) {
            OurProducts.dispose();
        }
        if (deliveredllOrderForm != null) {
            deliveredllOrderForm.dispose();
        }
        if (cancellOrderForm != null) {
            cancellOrderForm.dispose();
        }
        if (pendingOrderForm != null) {
            pendingOrderForm.dispose();
        }
        if (subAdminForm != null) {
            subAdminForm.dispose();
        }
        if (locationForm != null) {
            locationForm.dispose();
        }
        if (allCustomerForm != null) {
            allCustomerForm.dispose();
        }
        if (OurAttributes != null) {
            OurAttributes.dispose();
        }
        if (OurAttributesValues != null) {
            OurAttributesValues.dispose();
        }
        if (OurSubProducts != null) {
            OurSubProducts.dispose();
        }
        if (OurSubCat != null) {
            OurSubCat.dispose();
        }
        if (editProductForm != null) {
            editProductForm.dispose();
        }
        if (productImageForm != null) {
            productImageForm.dispose();
        }
        if (productAttributes != null) {
            productAttributes.dispose();
        }
        if (ourProductsAll != null) {
            ourProductsAll.dispose();
        }
        if (insertProAtt != null) {
            insertProAtt.dispose();
        }
        if (insertNewProAtt != null) {
            insertNewProAtt.dispose();
        }
        
        
        
        if (allAccountHolderDetail != null) {
            allAccountHolderDetail.dispose();
        }
        if (addAccountForm != null) {
            addAccountForm.dispose();
        }
        if (ledgerEntryForm != null) {
            ledgerEntryForm.dispose();
        }
        if (ledgerUpdateForm != null) {
            ledgerUpdateForm.dispose();
        }
        if (singleAccountHlderDetail != null) {
            singleAccountHlderDetail.dispose();
        }
        if (ledgerDailyDataForm != null) {
            ledgerDailyDataForm.dispose();
        }
        if (LegerDailyDetailForm != null) {
            LegerDailyDetailForm.dispose();
        }
        if (allTotalDetailForm != null) {
            allTotalDetailForm.dispose();
        }
      

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarThumb[Enabled].backgroundPainter",
                    new FillPainter(new Color(255, 255, 255)));
            UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarThumb[MouseOver].backgroundPainter",
                    new FillPainter(new Color(192, 41, 40)));
            UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarTrack[Enabled].backgroundPainter",
                    new FillPainter(new Color(255, 255, 255)));
            UIManager.getLookAndFeelDefaults().put("ScrollBar:\"ScrollBar.button\".size", 20);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm1().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAttribute;
    private javax.swing.JButton btnAttributeValue;
    private javax.swing.JButton btnBusiness;
    private javax.swing.JButton btnCancelledOrder;
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDeliveredOrder;
    private javax.swing.JButton btnEntry;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHome10;
    private javax.swing.JButton btnHome11;
    private javax.swing.JButton btnHome8;
    private javax.swing.JButton btnHome9;
    private javax.swing.JButton btnLocations;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLogo;
    private javax.swing.JButton btnLogo10;
    private javax.swing.JButton btnLogo11;
    private javax.swing.JButton btnLogo8;
    private javax.swing.JButton btnLogo9;
    private javax.swing.JButton btnPages;
    private javax.swing.JButton btnPendingOrder;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnSliders;
    private javax.swing.JButton btnTitleOne;
    private javax.swing.JButton btnTitleThree;
    private javax.swing.JButton btnTitleTwo;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuBar menueBar;
    private javax.swing.JMenuBar menueBar1;
    private javax.swing.JPanel pnlActionBar1;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
