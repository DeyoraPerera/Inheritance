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

class teacher extends person{
	
	protected String subject;//instantiating String subject
	//constructor
	public teacher(JTextField nameField, JComboBox comboBoxHair, JComboBox comboBoxEye, JComboBox comboBoxGender, JComboBox comboBoxSubject1) {
		super(nameField, comboBoxHair, comboBoxEye, comboBoxGender);
		
		setName(nameField);//setting name
		setHair(comboBoxHair);//setting height
		setEye(comboBoxEye);//setting age
		setGender(comboBoxGender);//setting gender
		setSubject(comboBoxSubject1);//setting grade
		// TODO Auto-generated constructor stub
	}//teacher constructor
	
	//overload constructor
	public teacher (String readName, String readHair, String readEye, String readGender, String readSubject) {
		super();
		name = readName;//name equals readName
		hair = readHair;//height equals readHeight
		eye = readEye;//age equals readAge
		gender = readGender;//gender equals readGender
		subject = readSubject;//grade equals readGrade
	}//overload constructor teacher
	
	public teacher() {//empty teacher constructor
		super();
	}
	
	public void setSubject(JComboBox comboBoxSubject1) {//method to set field to selected item from comboBoxSubject1
		subject = (String) comboBoxSubject1.getSelectedItem ();//getting selected subject from comboBoxSubject1
	}
    public String getSubject() {//method to return subject
    	return subject;//return subject
    }
	
}
