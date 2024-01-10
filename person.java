
/*Deyora Perera
  Course: ICS4U
  Assignment: Inheritance
  Due date: March 21
  Program Description: Making characters seen in educational environments like students (domestic and international), people, teachers
  
  Example of Override : class person (line 62-67) and class student (line 52-57)
  Example of Overload: class person(line 27-32), class student (line 32-39), class teacher (line 32 -39), class international (line 32 -40), class DeyoraInheritance (line 711, 739, 768, 796)
  Example of Array of Records: DeyoraInheritance class (line 412, 418, 424, 430, 480, 486, 492, 498)
  
   */
//imports 
import javax.swing.JComboBox;
import javax.swing.JTextField;
public class person {//class person
protected String name, hair, eye, gender, greeting;
//Constructor
public person (JTextField nameField, JComboBox comboBoxHair, JComboBox comboBoxEye, JComboBox comboBoxGender) {
	setName(nameField);//setting name
	setHair(comboBoxHair);//setting hair
	setEye(comboBoxEye);//setting age
	setGender(comboBoxGender);//setting gender	
}// person Constructor

//Overload constructor
public person (String readName,String readHair, String readEye, String readGender) {
	name = readName;// name equals readName
	hair = readHair;// hair equals readHair
	eye = readEye;//eye equals readEye
	gender = readGender;// gender equals readGender
}//person overload constructor

public person () {//empty person constructor
}

public void setName(JTextField nameField) {//method to set field to text from nameField
		name =nameField.getText();//getting text from nameField
}
public String getName() {//method to return name
	return name;//return name
}
public void setHair (JComboBox comboBoxHair) {//method to set field to selected item from comboBoxHair
	hair = (String) comboBoxHair.getSelectedItem ();//getting selected item from comboBoxHair
}
public String getHair() {//method to return hair 
	return hair;//return hair
}
public void setEye(JComboBox comboBoxEye) {//method to set field to selected item from comboBoxEye
	eye = (String) comboBoxEye.getSelectedItem ();//getting selected item from comboBoxEye
}
public String getEye() {//method to return eye
	return eye;//return eye
}
public void setGender(JComboBox comboBoxGender) {//method to set field to selected item from comboBoxGender
	gender = (String) comboBoxGender.getSelectedItem ();//getting selected item from comboBoxGEnder
}
public String getGender() {//method to return gender
	return gender;//return gender
}
//override example
public String getGreeting() {//getter method for variable greeting
	return greeting;//return greeting
}
public void setGreeting() {//setter method for variable greeting
	greeting = "hi";//greeting equals "hi"
}
}





