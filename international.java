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
class international extends student{ //class international inherits student class
protected String continent;//instantiating variable Continent as String
//constructor
	public international(JTextField nameField, JComboBox comboBoxHair, JComboBox comboBoxEye,
			JComboBox comboBoxGender, JComboBox comboBoxGrade, JComboBox comboBoxContinent) {
		super(nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxGrade);
		
		setName(nameField);// setting name
		setHair(comboBoxHair);//setting Height
		setEye(comboBoxEye);//setting Age
		setGender(comboBoxGender);//setting Gender
		setGrade(comboBoxGrade);//setting Grade
		setContinent(comboBoxContinent);//setting Continent
		// TODO Auto-generated constructor stub
	}//international constructor
	
//overload constructor
	public international (String readname, String readHair, String readEye, String readGender, String readGrade, String readContinent) {
		super();
		name = readname;// name equals readName
		hair = readHair;//hair equals readHair
		eye = readEye;//eye equals readEye
		gender = readGender;// gender equals readGender
		grade = readGrade;//grade equals readGrade
		continent = readContinent;//continent equals readContinent
	}//overload constructor international
	
	public void setContinent(JComboBox comboBoxContinent) {//method to set field to selected item from comboBoxContinent
		continent = (String) comboBoxContinent.getSelectedItem ();//getting selected continent from comboBoxContinent 
	}
	public String getContinent() {//returning continent
		return continent;//return continent
	}
}
