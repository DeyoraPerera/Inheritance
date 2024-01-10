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

class student extends person {//class student inherits person
	
protected String grade;//instantiating string grade
//constructor
	public student(JTextField nameField, JComboBox comboBoxHair, JComboBox comboBoxEye, JComboBox comboBoxGender, JComboBox comboBoxGrade) {
		super(nameField, comboBoxHair, comboBoxEye, comboBoxGender);
		
		setName(nameField);//setting name
		setHair(comboBoxHair);//setting height
		setEye(comboBoxEye);//setting age
		setGender(comboBoxGender);//setting gender
		setGrade(comboBoxGrade);//setting grade
		// TODO Auto-generated constructor stub
	}//student constructor
	
	//Overload constructor
	public student (String readName, String readHair, String readEye, String readGender, String readgrade) {
		super();
		name = readName;//name equals readName
		hair = readHair;//height equals readHeight
		eye = readEye;//age equals readAge
		gender = readGender;//gender equals readGender
		grade = readgrade;//grade equals readGrade
	}//person overload constructor
	
	public student () {//empty student constructor
		super();
	}
	public void setGrade(JComboBox comboBoxGrade) {//method to set field to selected item from comboBoxGrade
		grade = (String) comboBoxGrade.getSelectedItem ();//getting selected item from comboBoxgrade
	}
    public String getGrade() {//method to return grade
    	return grade;//return grade
    }
    
    //override example
    public String getGreeting() {//getter method for greeting
    	return greeting;//return greeting
    }
    public void setGreeting() {//setter method for greeting
    	greeting = "bye";//greeting equals "bye"
    }
}
