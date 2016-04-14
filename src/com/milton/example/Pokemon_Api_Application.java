package com.milton.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pokemon_Api_Application{
	private JFrame main_frame;
	private JTextArea enterTextArea = new JTextArea("Enter Id");

	@SuppressWarnings("unchecked")
	public Pokemon_Api_Application(){
		main_frame = new JFrame();//Make main frame
		JPanel temp = new JPanel();
		
		temp.setLayout(new GridLayout(3,1));
		temp.add(enterTextArea);
		
		JPanel temp2 = new JPanel();
		temp2.setLayout(new GridLayout(2,1));
		JComboBox<TypeOfCall> enumDropdown = new JComboBox<TypeOfCall>();
		enumDropdown.setModel(new DefaultComboBoxModel<TypeOfCall>(TypeOfCall.values()));
		temp2.add(enumDropdown);
		JButton tempButton = new JButton("All done?");
		tempButton.addActionListener(e -> {
            System.out.println("Handled Lambda listener");
            System.out.println("Have fun!");
            System.out.println((TypeOfCall)enumDropdown.getSelectedItem());
        });
		temp2.add(tempButton);
		
		temp.add(temp2);
		
		
		
		main_frame.add(temp);
		main_frame.setSize(300,300);  //set size
      	main_frame.setVisible(true);  //set visibility
	}
	public static void main(String[] args) {
		Pokemon_Api_Getter pag = new Pokemon_Api_Getter(TypeOfCall.POKEMON);
		pag.setId(5);
		pag.getDataForType();
		new Pokemon_Api_Application();	
	}
}