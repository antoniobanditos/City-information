package zad1;

import java.awt.event.MouseEvent;

import javax.swing.*;


import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import java.awt.Color;

public class Output {
	
	// Variables declaration 
	private Dialog parent_window;
	private Service service;
	private String city; 
	private String currency;
	
		//GUI variables
	    private final JFrame frame = new JFrame();
	    private JButton change_Settings_Button;
	    private JLabel weather_Label;
	    private JLabel rate_to_Currency_Label;
	    private JLabel rate_to_NBP_Label;
	    private JPanel main_Panel;
	    private JPanel panel_for_JFXPanel;
	    private JLabel to_Currency_Value_Label;
	    private JLabel to_NBP_Value_Label;
	    private JLabel weather_Value_Label;
    // End of variables declaration 
	
	/**
	 * Create the application.
	 */
	public Output(Dialog dialog,String country, String city, String currency) {
        
        this.parent_window=dialog;
        service= new Service(country);
        this.city=city;
        this.currency=currency;
        initialize();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main_Panel = new JPanel();
		main_Panel.setBackground(new Color(240, 255, 255));
        weather_Value_Label = new JLabel();
        to_Currency_Value_Label = new JLabel();
        weather_Label = new JLabel();
        rate_to_Currency_Label = new JLabel();
        rate_to_NBP_Label = new JLabel();
        to_NBP_Value_Label = new JLabel();
        panel_for_JFXPanel = new JPanel();
        change_Settings_Button = new JButton();
        change_Settings_Button.setBackground(UIManager.getColor("Button.highlight"));
        weather_Value_Label.setText(service.getWeather(city));
        to_Currency_Value_Label.setText(service.getRateTo(currency).toString());
        to_NBP_Value_Label.setText(service.getNBPRate().toString());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        weather_Value_Label.setFont(new java.awt.Font("Sitka Text", 2, 18)); // NOI18N

        to_Currency_Value_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        weather_Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        weather_Label.setText("Weather:");
        weather_Label.setToolTipText("");

        rate_to_Currency_Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rate_to_Currency_Label.setText("Rate to "+currency+":");

        rate_to_NBP_Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rate_to_NBP_Label.setText("Rate to PLN:");

        to_NBP_Value_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        panel_for_JFXPanel.setToolTipText("");

        GroupLayout panel_for_JFXPanelLayout = new GroupLayout(panel_for_JFXPanel);
        panel_for_JFXPanel.setLayout(panel_for_JFXPanelLayout);
        panel_for_JFXPanelLayout.setHorizontalGroup(
            panel_for_JFXPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_for_JFXPanelLayout.setVerticalGroup(
            panel_for_JFXPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        change_Settings_Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        change_Settings_Button.setText("Change settings");
        change_Settings_Button.setToolTipText("");
        change_Settings_Button.setFocusTraversalPolicyProvider(true);
        change_Settings_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                change_Settings_ButtonMouseClicked(evt);
            }
        });
        
        JFXPanel fxPanel = new JFXPanel();
        fxPanel.setBackground(new Color(240, 255, 255));
        fxPanel.setSize(1000,500);
        Platform.runLater(() -> {
       	    WebView webView = new WebView();
       	    webView.getEngine().load("https://en.wikipedia.org/wiki/"+city);
       	    fxPanel.setScene(new Scene(webView));
       	});
        
        panel_for_JFXPanel.add(fxPanel);
       // loadJavaFXScene(panel_for_JFXPanel);
        
        GroupLayout main_PanelLayout = new GroupLayout(main_Panel);
        main_Panel.setLayout(main_PanelLayout);
        main_PanelLayout.setHorizontalGroup(
            main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(main_PanelLayout.createSequentialGroup()
                        .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(rate_to_Currency_Label, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                            .addComponent(to_Currency_Value_Label, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123)
                        .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(rate_to_NBP_Label, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(to_NBP_Value_Label, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(main_PanelLayout.createSequentialGroup()
                        .addComponent(weather_Label, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(weather_Value_Label, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(change_Settings_Button, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel_for_JFXPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        main_PanelLayout.setVerticalGroup(
            main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_PanelLayout.createSequentialGroup()
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(main_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(weather_Value_Label, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(weather_Label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(main_PanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rate_to_Currency_Label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addGroup(main_PanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rate_to_NBP_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(change_Settings_Button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(to_Currency_Value_Label, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addComponent(to_NBP_Value_Label, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_for_JFXPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(main_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(main_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        frame.pack();
	}
	private void change_Settings_ButtonMouseClicked(MouseEvent evt) { 
   	 parent_window.getFrame().setVisible(true);
   	 frame.dispose();
    }

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}          

}
