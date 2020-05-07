package zad1;

import java.awt.EventQueue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class Dialog {
	
	// Variables declaration 
	private final JFrame frame = new JFrame();
	private JButton show_Button;
    private JLabel city_Label;
    private JLabel country_Label;
    private JLabel rate_to_Label;
    private JLabel error_Label;
    private JPanel main_Panel;
    private JTextField jtfCity;
    private JTextField jtfCountry;
    private JTextField jtfCurrency;
 // End of variables declaration 

	/**
	 * Create the application.
	 */
	public Dialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main_Panel = new JPanel();
        show_Button = new JButton();
        city_Label = new JLabel();
        country_Label = new JLabel();
        jtfCountry = new JTextField();
        jtfCity = new JTextField();
        rate_to_Label = new JLabel();
        jtfCurrency = new JTextField();
        error_Label = new JLabel();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        show_Button.setFont(new Font("Sylfaen", 2, 18)); // NOI18N
        show_Button.setText("Show");
        show_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                show_ButtonActionPerformed(evt);
            }
        });

        city_Label.setFont(new Font("Tahoma", 0, 48)); // NOI18N
        city_Label.setText("City:");

        country_Label.setFont(new Font("Tahoma", 0, 48)); // NOI18N
        country_Label.setText("Country:");
        country_Label.setMaximumSize(new Dimension(97, 58));
        country_Label.setMinimumSize(new Dimension(97, 58));
        country_Label.setPreferredSize(new Dimension(97, 58));

        jtfCountry.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        jtfCity.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        rate_to_Label.setFont(new Font("Tahoma", 0, 48)); // NOI18N
        rate_to_Label.setText("Rate to:");

        GroupLayout main_PanelLayout = new GroupLayout(main_Panel);
        main_Panel.setLayout(main_PanelLayout);
        main_PanelLayout.setHorizontalGroup(
            main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_PanelLayout.createSequentialGroup()
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(main_PanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(main_PanelLayout.createSequentialGroup()
                                .addComponent(rate_to_Label, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfCurrency, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                            .addGroup(main_PanelLayout.createSequentialGroup()
                                .addComponent(city_Label, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfCity))
                            .addGroup(main_PanelLayout.createSequentialGroup()
                                .addComponent(country_Label, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfCountry, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(main_PanelLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(show_Button, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(error_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        main_PanelLayout.setVerticalGroup(
            main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, main_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(main_PanelLayout.createSequentialGroup()
                        .addComponent(city_Label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfCity))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfCountry)
                    .addComponent(country_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCurrency, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate_to_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(main_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(show_Button, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(error_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        main_Panel.setBackground(new Color(240, 248, 255));

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(main_Panel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(main_Panel, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
        );
        frame.getContentPane().setLayout(layout);

        frame.pack();
    }// </editor-fold>                        
	
    private void show_ButtonActionPerformed(ActionEvent evt) {
    	String country = new String(jtfCountry.getText());
    	String city = new String(jtfCity.getText());
    	String waluta=	new String(jtfCurrency.getText());
    	if(country.equals("")|| city.equals("")|| waluta.equals("")) {
    		error_Label.setText("Not enough inf.");
    	}
    	else {
    		Dialog d =this;
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Output(d,country, city, waluta).getFrame().setVisible(true);
            }
        });
    	jtfCountry.setText("");
    	jtfCity.setText("");
    	jtfCurrency.setText("");
    	error_Label.setText("");
    	frame.setVisible(false);
    	}
    	
    }                                            


	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
