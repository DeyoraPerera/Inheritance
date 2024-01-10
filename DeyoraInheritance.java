/*Deyora Perera
  Course: ICS4U
  Assignment: Inheritance
  Due date: March 21
  Program Description: Making characters seen in educational environments like students (domestic and international), people, teachers
  
  Example of Override : class person (line 62-67) and class student (line 52-57)
  Example of Overload: class person(line 27-32), class student (line 32-39), class teacher (line 32 -39), class international (line 32 -40), class DeyoraInheritance (line 706, 734, 763, 791)
  Example of Array of Records: DeyoraInheritance class (line 408, 414, 420, 426, 476, 482, 488, 494)
  
   */
//imports 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
public class DeyoraInheritance extends JFrame {
	private JPanel contentPane;
	static String Name, Height,Age,Gender,grade,continent,choice; //String variables for features of character, and choice of what type of character
	static JLabel nameLabel;// label for typing user's name
	static JLabel viewlabel;//label for viewing characters
	static JTextField nameField;//textField for user to type character's name
	static JButton savePerson;//button to save character
	static JButton addStudentButton;//button to add student
	static JButton addPersonButton;//button to add person
	static JButton addInterStudentButton;//button to add international student
	static JButton addTeacherButton;//button to add teacher+
	static JButton viewButton;//button to view characters
	static JButton editButton;//button to edit characters
	static JButton exitButton;//button to exit game
	static JButton cancelButton;//button to cancel selection and go back to main page
	static JButton removeButton;//button to remove character
	static JTextArea textarea;//textarea to add the characteristics of the characters
	static JComboBox comboBoxEye;//comboBox for choosing age
	static JComboBox comboBoxGender;//comboBox for choosing gender
	static JComboBox comboBoxHair;//comboBox for choosing height
	static JComboBox comboBoxContinent;//comboBox for choosing continent
	static JComboBox comboBoxView;//comboBox for choosing which character to view
	static JComboBox comboBoxSubject1;//comboBox for choosing subject
	static JComboBox comboBoxGrade;//comboBox for choosing grade
	static int numEntries =0;//numEntries for number of person entries
	static int studentCnt=0;//studentCnt for number of student entries
	static int interStudentCnt =0;//interStudentCnt for number of international student entries
	static int teacherCnt = 0;//teacherCnt for number of teacher entries
	static int doneChoice;//doneChoice to see if user finalized choice for edit or remove
	static person [] P = new person [10]; //array of size 10 of person objects
	static student [] S = new student [10];//array of size 10 of student objects
	static international [] I = new international [10];//array of size 10 of international objects
	static teacher [] T = new teacher [10];//array size 10 of teacher objects
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeyoraInheritance frame = new DeyoraInheritance(); //creating frame
					frame.setVisible(true);//making frame visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});	
	}
	public DeyoraInheritance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);//setting bounds
		contentPane = new JPanel(); //-------------------------------
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//------------------
		JPanel panel = new JPanel();//-----------------------
		textarea = new JTextArea (5,20); //instantiate text area
		textarea.setEditable (false); //make textarea as read only!
		nameLabel = new JLabel ("Enter Name here:\n", JLabel.RIGHT); //instantiate a label with the text set to right justified on the label
		nameLabel.setFont (new Font ("Serif", Font.BOLD, 12));//setting font to 12 Serif Bold
		nameLabel.setForeground (Color.red);//label colour red
		viewlabel = new JLabel ("", JLabel.RIGHT); //instantiate a label with the text set to right justified on the label
		viewlabel.setFont (new Font ("Serif", Font.BOLD, 12));//setting font to 12 Serif Bold
		viewlabel.setForeground (Color.red);//label colour red
		nameField = new JTextField (10); // the value of ten is just for the visual size not max size of the data that can be stored by the component
		String arrayEyes [] = {"Blue eyes", "Green eyes", "Dark Brown eyes", "Hazel Eyes"};//array of eye colour options
		String arrayGender [] = {"Female", "Male", "Other"};//array of gender options
		String arrayHair [] = {"Black hair", "Brown hair", "Blonde Hair", "Red Hair" };//array of hair options
		String arrayContinent [] = {"Africa","Asia", "North America", "South America", "Europe","Australia"};//array of continent options
		String arrayGradelvl [] = {"Grade 9","Grade 10", "Grade 11", "Grade 12" };//array of grade options
		String arraySub1 [] = {"Teaching Math","Teaching Science", "Teaching Geography", "Teaching Phys Ed" };// array of subjects options
		String viewCharacter [] = {"View"};//array of characters
		comboBoxEye = new JComboBox(arrayEyes);//instantiating comboBoxEye with array arrayEyes
		comboBoxGender = new JComboBox(arrayGender);//instantiating comboBoxGender with array arrayGender
		comboBoxHair = new JComboBox(arrayHair);//instantiating comboBoxHair with array arrayHair
		comboBoxContinent = new JComboBox(arrayContinent);//instantiating comboBoxContinent with array  arrayContinent
		comboBoxGrade = new JComboBox(arrayGradelvl);//instantiating comboBoxGrade with array  arrayGradelvl
		comboBoxSubject1 = new JComboBox(arraySub1);//instantiating comboBoxSubject1 with array arraySub1
		comboBoxView = new JComboBox(viewCharacter);//instantiating comboBoxView with array viewCharacter
		panel.setLayout(null);
		JButton addInterStudentButton = new JButton("Add International Student");//instantiate addInterStudentButton with the label text of "Add International Student"
		JButton addPersonButton = new JButton("Add Person");//instantiate addPersonButton with the label text of "Add Person"
		JButton addStudentButton = new JButton("Add Student");//instantiate addStudentButton with the label text of "Add Student"
		JButton addTeacherButton = new JButton("Add Teacher");//instantiate addTeacherButton with the label text of "Add Teacher"
		JButton editButton = new JButton("Edit");//instantiate editButton with the label text of "Edit"
		JButton savePerson = new JButton("Save Choice(s)");//instantiate savePerson with the label text of "Save"
		JButton viewButton = new JButton("View Characters");//instantiate viewButton with the label text of "View Characters"	
		JButton removeButton = new JButton("Remove");//instantiate removeButton with the label text of "Remove"
		JButton cancelButton = new JButton("Cancel");//instantiate cancelButton with the label text of "Cancel"
		JButton exitButton = new JButton("Exit");//instantiate exitButton with the label text of "Exit"
		setContentPane(contentPane);
		contentPane.add(nameLabel);//add nameLabel to the panel
		contentPane.add(nameField);//add nameField to the panel
		contentPane.add(viewlabel);//add viewLabel to the panel
		contentPane.add(comboBoxEye);//add comboBoxEye to the panel
		contentPane.add(comboBoxGender);//add comboBoxGender to the panel
		contentPane.add(comboBoxHair);//add comboBoxHair to the panel
		contentPane.add(comboBoxContinent);//add comboBoxContinent to the panel
		contentPane.add(comboBoxGrade);//add comboBoxGrade to the panel
		contentPane.add(comboBoxSubject1);//add comboBoxSubject1 to the panel
		contentPane.add(comboBoxView);//add comboBoxView to the panel
		contentPane.add (textarea);//add textarea to the panel
		contentPane.add(panel);//add panel to the panel
		contentPane.add(addInterStudentButton); //add addInterStudentButton to the panel
		contentPane.add(addPersonButton);//add addPersonButton to the panel
		contentPane.add(addStudentButton);//add addStudentButton to the panel
		contentPane.add(addTeacherButton);//add addTeacherButton to the panel
		contentPane.add(editButton);//add edittButton to the panel
		contentPane.add(savePerson);//add savePerson to the panel
		contentPane.add(viewButton);//add viewButton to the panel
		contentPane.add(removeButton);//add removeButton to the panel
		contentPane.add(cancelButton);//add cancelButton to the panel
		contentPane.add(exitButton);//add exitButton to the panel
		addInterStudentButton.setVisible(true);//making addInterStudentButton visible
		addPersonButton.setVisible(true);//making addPersonButton visible
		addStudentButton.setVisible(true);//making addStudentButton visible
		addTeacherButton.setVisible(true);//making addTeacherButton visible
		comboBoxEye.setVisible(false);//making comboBoxEye not visible
		comboBoxGender.setVisible(false);//making comboBoxGender not visible
		comboBoxHair.setVisible(false);//making comboBoxHair not visible
		comboBoxContinent.setVisible(false);//making comboBoxContinent not visible
		comboBoxGrade.setVisible(false);//making comboBoxGrade not visible
		comboBoxSubject1.setVisible(false);//making comboBoxSubject1 not visible
		comboBoxView.setVisible(false);//making comboBoxView not visible
		savePerson.setVisible(false);//making savePerson button not visible
		viewButton.setVisible(true);//making viewButton visible
		nameLabel.setVisible(false);//making nameLabel not visible
		nameField.setVisible(false);//making nameField not visible
		textarea.setVisible(false);//making textarea not visible
		editButton.setVisible(false);//making editButton not visible
		removeButton.setVisible(false);//making removeButton not visible
		cancelButton.setVisible(true);//making cancelButton visible
		exitButton.setVisible(true);//making exitButton visible
		readCharacters();//calling read characters method
	
		editButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for editButton
			public void actionPerformed(ActionEvent e) {
				doneChoice =1;
				comboBoxView.setVisible(false);//making comboBoxView not visible
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				nameLabel.setVisible(true);//making nameLabel visible
				nameField.setVisible(true);//making nameField visible
				editButton.setVisible(false);//making editButton not visible
				removeButton.setVisible(false);//making removeButton not visible
				textarea.setVisible(false);//making textarea not visible
				comboBoxView.setVisible(false);//making comboBoxView not visible
				textarea.setText("");//setting textarea text to blank string
				comboBoxEye.setVisible(true);// making comboBoxEye visible
				comboBoxGender.setVisible(true);// making comboBoxGender visible
				comboBoxHair.setVisible(true);// making comboBoxHair visible
				cancelButton.setVisible(false);//making cancelButton visible
				savePerson.setVisible(true);//making savePerson button visible
				cancelButton.setVisible(true);//making cancel button visible
				String option = (String) comboBoxView.getSelectedItem();//setting option to selected item from comboBoxView
				for ( int i=0; i<numEntries; i++) { //looping through numEntries
					if (option.equals(P[i].getName())) { //if option equals name of person object index i
						choice="1";//choice equals 1
						nameField.setText(P[i].getName());//set nameField to name of person object at index i
						comboBoxEye.setSelectedItem(P[i].getEye());//set comboBoxEye to age of person object at index i
						comboBoxGender.setSelectedItem(P[i].getGender());//set comboBoxGender to gender of person object at index i
						comboBoxHair.setSelectedItem(P[i].getHair());//set comboBoxHair to height of person object at index i
					} 
				} 
				for ( int j =0; j<studentCnt; j++) {//looping through studentCnt
					if (option.equals(S[j].getName())) {//if option equals name of student object at index j
						choice="2";// choice equals 2
						nameField.setText(S[j].getName());//set nameField to name of student object at index j
						comboBoxEye.setSelectedItem(S[j].getEye());//set comboBoxEye to age of student object at index j
						comboBoxGender.setSelectedItem(S[j].getGender());//set comboBoxGender to gender of student object at index j
						comboBoxHair.setSelectedItem(S[j].getHair());//set comboBoxHair to height of student object at index j
						comboBoxGrade.setSelectedItem(S[j].getGrade());//set comboBoxGrade to grade of student object at index j
						comboBoxGrade.setVisible(true);//making comboBoxGrade visible
					}
				}
				for (int y =0; y< interStudentCnt; y++) {//looping through interStudentCnt
					if (option.equals(I[y].getName())) {//if option equals name of international object at index y
						choice="3";//choice equals 3
						nameField.setText(I[y].getName());//set nameField to name of student object at index j	
						comboBoxEye.setSelectedItem(I[y].getEye());//set comboBoxEye to age of international object at index y
						comboBoxGender.setSelectedItem(I[y].getGender());//set comboBoxGender to gender of international object at index y
						comboBoxHair.setSelectedItem(I[y].getHair());//set comboBoxHair to height of international object at index y
						comboBoxGrade.setSelectedItem(I[y].getGrade());//set comboBoxGrade to grade of international object at index y
						comboBoxContinent.setSelectedItem(I[y].getContinent());//set comboBoxContinent to continent of international object at index y
						comboBoxGrade.setVisible(true);//making comboBoxGrade visible
						comboBoxContinent.setVisible(true);//making comboBoxHair visible
					}
				}
			
			for (int g =0; g< teacherCnt; g++) {//looping through teacherCnt
				if (option.equals(T[g].getName())) {//if option equals name of teacher object at index g
					choice="4";//choice equals 4
					nameField.setText(T[g].getName());//set nameField to name of teacher object at index j	
					comboBoxEye.setSelectedItem(T[g].getEye());//set comboBoxEye to age of teacher object at index g
					comboBoxGender.setSelectedItem(T[g].getGender());//set comboBoxGender to gender of teacher object at index g
					comboBoxHair.setSelectedItem(T[g].getHair());//set comboBoxHair to height of teacher object at index g
					comboBoxSubject1.setSelectedItem(T[g].getSubject());//set comboBoxSubject to subject of teacher object at index g
					comboBoxSubject1.setVisible(true);//making comboBoxGrade visible
				}
			
			}
			}
		});
		removeButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for removeButton
			public void actionPerformed(ActionEvent e) {
				editButton.setVisible(false);//making editButton not visible
				removeButton.setVisible(false);//making removeButton not visible
				textarea.setVisible(false);//making textarea not visible
				comboBoxView.setVisible(false);//making comboBoxView not visible
				textarea.setText("");//setting textarea text to blank string
				savePerson.setVisible(true);//making savePerson button visible
				cancelButton.setVisible(true);//making cancel button visible
				doneChoice =2;//doneChoice equals 2
			}
		});
		addInterStudentButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for addStudentButton
			public void actionPerformed(ActionEvent e) {
				comboBoxEye.setVisible(true);//making comboBoxEye visible
				comboBoxGender.setVisible(true);//making comboBoxGender visible
				comboBoxHair.setVisible(true);//making comboBoxHair visible
				comboBoxGrade.setVisible(true);//making comboBoxGrade visible
				comboBoxContinent.setVisible(true);//making comboBoxContinent visible
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				comboBoxView.setVisible(false);//making comboBoxView not visible
				viewButton.setVisible(false);//making viewButton not visible
				savePerson.setVisible(true);//making savePerson button visible
				nameLabel.setVisible(true);//making nameLabel visible
				nameField.setVisible(true);//making nameField visible
				choice = "3";//choice equals 4
			}
		});
		viewButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for viewButton
			public void actionPerformed(ActionEvent e) {
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				viewlabel.setVisible(true);//making viewLabel visible
				comboBoxView.setVisible(true);//making comboBoxView visible
				textarea.setVisible(true);//making textarea visible
				editButton.setVisible(true);//making editButton visible
				removeButton.setVisible(true);//making removeButton visible
				viewButton.setVisible(false);//making viewButton not visible
			}
		});
		addPersonButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for addPersonButton
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");//making nameField empty text
				comboBoxEye.setVisible(true);//making comboBoxEye visible
				comboBoxGender.setVisible(true);//making comboBoxGender visible
				comboBoxHair.setVisible(true);//making comboBoxHair visible
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				savePerson.setVisible(true);//making savePerson button visible
				viewButton.setVisible(false);//making viewButton not visible
				nameLabel.setVisible(true);//making nameLabel visible
				nameField.setVisible(true);//making nameField visible
				choice = "1";// choice equals 1
			}
		});
		addStudentButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for addStudentButton
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");//setting nameField text to blank
				comboBoxEye.setVisible(true);//making comboBoxEye visible
				comboBoxGender.setVisible(true);//making comboBoxGender visible
				comboBoxHair.setVisible(true);//making comboBoxHair visible
				comboBoxGrade.setVisible(true);//making comboBoxGrade visible
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				savePerson.setVisible(true);//making savePerson button visible
				viewButton.setVisible(false);//making viewButton not visible
				nameLabel.setVisible(true);//making nameLabel visible
				nameField.setVisible(true);//making nameField visible
				choice ="2";//choice equals 2
			}
		});
		addTeacherButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for addStudentButton
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");//setting nameField text to blank
				comboBoxEye.setVisible(true);//making comboBoxEye visible
				comboBoxGender.setVisible(true);//making comboBoxGender visible
				comboBoxHair.setVisible(true);//making comboBoxHair visible
				comboBoxSubject1.setVisible(true);//making comboBoxGrade visible
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				savePerson.setVisible(true);//making savePerson button visible
				viewButton.setVisible(false);//making viewButton not visible
				nameLabel.setVisible(true);//making nameLabel visible
				nameField.setVisible(true);//making nameField visible
				choice ="4";//choice equals 4
			}
		});
		addInterStudentButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for addInterStudentButton
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");//setting nameField text to blank
				comboBoxEye.setVisible(true);//making comboBoxEye visible
				comboBoxGender.setVisible(true);//making comboBoxGender visible
				comboBoxHair.setVisible(true);//making comboBoxHair visible
				comboBoxGrade.setVisible(true);//making comboBoxGrade visible
				comboBoxContinent.setVisible(true);//making comboBoxContinent visible
				addPersonButton.setVisible(false);//making addPersonButton not visible
				addStudentButton.setVisible(false);//making addStudentButton not visible
				addInterStudentButton.setVisible(false);//making addInterStudentButton not visible
				addTeacherButton.setVisible(false);//making addTeacherButton not visible
				viewButton.setVisible(false);//making viewButton not visible
				savePerson.setVisible(true);//making savePerson button visible
				nameLabel.setVisible(true);//making nameLabel visible
				nameField.setVisible(true);//making nameField visible
				choice = "3";//choice equals 3
			}
		});
		savePerson.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for savePerson
			public void actionPerformed(ActionEvent e) {
				comboBoxEye.setVisible(false);//making comboBoxEye not visible
				comboBoxGender.setVisible(false);//making comboBoxGender not visible
				comboBoxHair.setVisible(false);//making comboBoxHair not visible
				comboBoxGrade.setVisible(false);//making comboBoxGrade not visible
				comboBoxContinent.setVisible(false);//making comboBoxContinent not visible
				comboBoxSubject1.setVisible(false);
				addPersonButton.setVisible(true);//making addPersonButton not visible
				addStudentButton.setVisible(true);//making addStudentButton visible
				addInterStudentButton.setVisible(true);//making addInterStudentButton visible
				addTeacherButton.setVisible(true);	//making addTeacherButton visible
				comboBoxView.setVisible(false);//making comboBoxView not visible
				savePerson.setVisible(false);//making savePerson not visible
				viewButton.setVisible(true);//making viewButton visible
				nameLabel.setVisible(false);//making nameLabel not visible
				nameField.setVisible(false);//making nameField not visible
				cancelButton.setVisible(true);//making the cancel button visible
				textarea.setText("");//set text of textarea to blank String
				
				if (doneChoice ==1) {//if doneChoice equals 1, edit button was pressed before
				String option = (String) comboBoxView.getSelectedItem();// String option equals String selectedItem from comboBoxView
				for ( int i=0; i<numEntries; i++) {//looping through numEntries
					if (option.equals(P[i].getName())) {//if option equals name of person object index i
						comboBoxView.removeItem(P[i].getName());//remove name of person object at index i from comboBoxView
						for ( int i1 = i +1; i++< numEntries; i1++) {//looping through numEntries
							P[i-1]= P[i1];	//removing person character
						}
						numEntries--;//numEntries minus 1
					}	 
				}
				for ( int j =0; j<studentCnt; j++) {//looping through studentCnt
					if (option.equals(S[j].getName())) {//if option equals name of student object at index j
						comboBoxView.removeItem(S[j].getName());//remove name of student object at index j from comboBoxView
						for ( int j1 = j +1; j++< studentCnt; j1++) {//looping through studentCnt
							S[j-1]= S[j1];	//removing student character
						}
						studentCnt--;//studentCnt minus 1
					}	 
				}
				for (int y =0; y< interStudentCnt; y++) {//looping through interStudentCnt
					if (option.equals(I[y].getName())) {//if option equals name of international object at index y
						comboBoxView.removeItem(I[y].getName());//remove name of international object at index y from comboBoxView
						for ( int y1 = y +1; y++< interStudentCnt; y1++) {//looping through interStudentCnt
							I[y-1]= I[y1];	//removing international Student character
						}
						interStudentCnt--;//interStudentCnt minus 1
					}
				}
				for (int g =0; g< teacherCnt; g++) {//looping through teacherCnt
					if (option.equals(T[g].getName())) {//if option equals name of teacher object at index g
						comboBoxView.removeItem(T[g].getName());//remove name of teacher object at index g from comboBoxView
						for ( int g1 = g +1; g++< teacherCnt; g1++) {//looping through teacherCnt
							T[g-1]= T[g1];	//removing teacher character
						}
						teacherCnt--;//teacherCnt minus 1
					}
				}
				if (choice.equals("1")){//if choice equals 1 (added person)
					P[numEntries] = new person (nameField, comboBoxHair, comboBoxEye, comboBoxGender); //instantiate new object of person and save to array at index numEntries
					comboBoxView.addItem(P[numEntries].getName());//add name of object at index numEntries to comboBoxView
					numEntries ++;//add one to numEntries
					choice = "";//choice is reset to blank
				}
				else if (choice.equals("2")) {//if choice equals 2 (added student)
					S[studentCnt] = new student (nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxGrade);//instantiate new object of student and save to array at index studentCnt
					comboBoxView.addItem(S[studentCnt].getName());
					studentCnt++;//add one to studentCnt
					choice = "";//choice is reset to blank
				}
				else if (choice.equals("3")) {//if choice equals 3 (added internationalStudent)
					I [interStudentCnt] = new international (nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxGrade, comboBoxContinent);//instantiate new object of international and save to array at index interStudentCnt
					comboBoxView.addItem(I[interStudentCnt].getName());//add one to interStudentCnt
					interStudentCnt++;//add one to interStudentCnt
					choice = "";//choice is reset to blank
				}
				else if (choice.equals("4")) {//if choice equals 4 (added teacher)
					T [teacherCnt] = new teacher (nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxSubject1);//instantiate new object of teacher and save to array at index teacherCnt
					comboBoxView.addItem(T[teacherCnt].getName());//add one to teacherCnt
					teacherCnt++;//add one to teacherCnt
					choice = "";//choice is reset to blank
				}
			}
				
			else if (doneChoice ==2) {// if doneChoice equals 2, remove button was pressed before
				
				String option = (String) comboBoxView.getSelectedItem();// String option equals String selectedItem from comboBoxView
				for ( int i=0; i<numEntries; i++) {//looping through numEntries
					if (option.equals(P[i].getName())) {//if option equals name of person object index i
						comboBoxView.removeItem(P[i].getName());//remove name of person object at index i from comboBoxView
						for ( int i1 = i +1; i++< numEntries; i1++) {//looping through numEntries
							P[i-1]= P[i1];	//removing person character
						}
						numEntries--;//numEntries minus 1
					}	 
				}
				for ( int j =0; j<studentCnt; j++) {//looping through studentCnt
					if (option.equals(S[j].getName())) {//if option equals name of student object at index j
						comboBoxView.removeItem(S[j].getName());//remove name of student object at index j from comboBoxView
						for ( int j1 = j +1; j++< studentCnt; j1++) {//looping through studentCnt
							S[j-1]= S[j1];	//removing student character
						}
						studentCnt--;//studentCnt minus 1
					}	 
				}
				for (int y =0; y< interStudentCnt; y++) {//looping through interStudentCnt
					if (option.equals(I[y].getName())) {//if option equals name of international object at index y
						comboBoxView.removeItem(I[y].getName());//remove name of international object at index y from comboBoxView
						for ( int y1 = y +1; y++< interStudentCnt; y1++) {//looping through international students
							I[y-1]= I[y1];	//removing international student character
						}
						interStudentCnt--;//interStudentCnt minus 1
					}
				}
				for (int g =0; g< teacherCnt; g++) {//looping through teacherCnt
					if (option.equals(T[g].getName())) {//if option equals name of teacher object at index g
						comboBoxView.removeItem(T[g].getName());//remove name of teacher object at index g from comboBoxView
						for ( int g1 = g +1; g++< teacherCnt; g1++) {//looping through teacherCnt
							T[g-1]= T[g1];	//removing teacher character
						}
						teacherCnt--;//teacherCnt minus 1
					}
				}
			}
			else {
					
				if (choice.equals("1")){//if choice equals 1 (added person)
					P[numEntries] = new person (nameField, comboBoxHair, comboBoxEye, comboBoxGender); //instantiate new object of person and save to array at index numEntries
					comboBoxView.addItem(P[numEntries].getName());//add name of object at index numEntries to comboBoxView
					numEntries ++;//add one to numEntries
					choice = "";//choice is reset to blank
				}
				else if (choice.equals("2")) {//if choice equals 2 (added student)
					S[studentCnt] = new student (nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxGrade);//instantiate new object of student and save to array at index studentCnt
					comboBoxView.addItem(S[studentCnt].getName());
					studentCnt++;//add one to studentCnt
					choice = "";//choice is reset to blank
				}
				else if (choice.equals("3")) {//if choice equals 3 (added internationalStudent)
					I [interStudentCnt] = new international (nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxGrade, comboBoxContinent);//instantiate new object of international and save to array at index interStudentCnt
					comboBoxView.addItem(I[interStudentCnt].getName());//add one to interStudentCnt
					interStudentCnt++;//add one to interStudentCnt
					choice = "";//choice is reset to blank
				}
				else if (choice.equals("4")) {//if choice equals 4 (added teacher)
					T [teacherCnt] = new teacher (nameField, comboBoxHair, comboBoxEye, comboBoxGender, comboBoxSubject1);//instantiate new object of teacher and save to array at index teacherCnt
					comboBoxView.addItem(T[teacherCnt].getName());//add one to teacherCnt
					teacherCnt++;//add one to teacherCnt
					choice = "";//choice is reset to blank
				}	
					
				doneChoice=0;//setting doneChoice variable to zero	
			}
			}
		});
		cancelButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for cancelButton
			public void actionPerformed(ActionEvent e) {
				comboBoxEye.setVisible(false);//making comboBoxEye not visible
				comboBoxGender.setVisible(false);//making comboBoxGender not visible
				comboBoxHair.setVisible(false);//making comboBoxHair not visible
				comboBoxGrade.setVisible(false);//making comboBoxGrade not visible
				comboBoxContinent.setVisible(false);//making comboBoxContinent not visible
				comboBoxSubject1.setVisible(false);//making comboBoxSubject1 not visible
				addPersonButton.setVisible(true);//making addPersonButton visible
				addStudentButton.setVisible(true);//making addStudentButton visible
				addInterStudentButton.setVisible(true);//making addInterStudentButton visible
				addTeacherButton.setVisible(true);//making addTeacherButton visible
				comboBoxView.setVisible(false);//making comboBoxView not visible
				savePerson.setVisible(false);//making savePerson button not visible
				editButton.setVisible(false);//making editButton not visible
				viewButton.setVisible(true);//making viewButton visible
				removeButton.setVisible(false);//making removeButton not visible
				textarea.setVisible(false);//making textarea not visible
				nameLabel.setVisible(false);//making nameLabel not visible
				nameField.setVisible(false);//making nameField not visible
			}
		});
		exitButton.addActionListener(new ActionListener() {//adding action listener to the button component and creating a specific action performed method (override) for exitButton
			public void actionPerformed(ActionEvent e) {
				writeCharacters();//calling writeCharacters method
				System.exit(0);//closing inheritance game
			}
		});
		comboBoxEye.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboBoxEye
				{
			public void actionPerformed (ActionEvent e)
			{
			}
				}
				);
		comboBoxGender.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboBoxGender
				{
			public void actionPerformed (ActionEvent e)
			{
			}
				}
				);
		comboBoxHair.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboBoxHair
				{
			public void actionPerformed (ActionEvent e)
			{
			}
				}
				);
		comboBoxGrade.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboBoxGrade
				{
			public void actionPerformed (ActionEvent e)
			{
			}
				}
				);
		comboBoxContinent.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboBoxContinent
				{
			public void actionPerformed (ActionEvent e)
			{
			}
				}
				);
		comboBoxSubject1.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboBoxSubject1
				{
			public void actionPerformed (ActionEvent e)
			{
			}
				}
				);
		comboBoxView.addActionListener (new ActionListener ()  //adding action listener to the combo box component and creating a specific action performed method (override) for the comboxBoxView
				{
			public void actionPerformed (ActionEvent e)
			{
				String option = (String) comboBoxView.getSelectedItem();//string option equals selected name from comboBoxView
				for ( int i=0; i<numEntries; i++) {//looping through numEntries
					if (option.equals(P[i].getName())) {//if option equals name in person object at index i 
						textarea.setText("Details for: " + P[i].getName() + "\n " + P[i].getHair() +"\n " + P[i].getEye() + "\n " + P[i].getGender());//output to textarea name, height, age, and gender in that index of person object
					}
				}
				for ( int j =0; j<studentCnt; j++) {//looping through studentCnt
					if (option.equals(S[j].getName())) {//if option equals name in student object at index j
						textarea.setText("Details for: " + S[j].getName() + "\n" + S[j].getHair() + "\n" + S[j].getEye() + "\n" + S[j].getGender() + "\n" + S[j].getGrade());//output to textarea name, height, age, gender, and grade in that index of student object
					} 
				}
				for (int y =0; y< interStudentCnt; y++) {//looping through interStudentCnt
					if (option.equals(I[y].getName())) {//if option equals name in international object at index y
						textarea.setText("Details for: " + I[y].getName() + "\n" + I[y].getHair() + "\n" + I[y].getEye() + "\n" + I[y].getGender() + "\n" + I[y].getGrade() + "\n" + I[y].getContinent());//output to textarea name, height, age, gender, grade, and continent in that index of international object
					}
				}
				for (int g =0; g< teacherCnt; g++) {//looping through teacherCnt
					if (option.equals(T[g].getName())) {//if option equals name in international object at index g
						textarea.setText("Details for: " + T[g].getName() + "\n" + T[g].getHair() + "\n" + T[g].getEye() + "\n" + T[g].getGender() + "\n" + T[g].getSubject());//output to textarea name, height, age, gender and subject in that index of teacher object
					}
				}
			}
		}
		);
	}
	public void writeCharacters() //method used to write to the files
	{
		try //because the PrintWriter object can generate IO exceptions use the try and catch Blocks
		{
			PrintWriter output; //object to connect to a file
			output = new PrintWriter (new FileWriter ("personData1")); //instantiate object
			for (int number = 0 ; number <numEntries; number ++) //for loop to loop through person entries
			{ 
				output.println(P[number].getName()); //store entry name
				output.println(P[number].getHair()); //store entry hair
				output.println(P[number].getEye());//store entry eye
				output.println(P[number].getGender()); //store gender
			}
			output.close (); //you must close the object to save the data in the personData1 file
			System.out.println ("personData1 file created with data!");
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch

		try //because the PrintWriter object can generate IO exceptions use the try and catch Blocks
		{
			PrintWriter output; //object to connect to a file
			output = new PrintWriter (new FileWriter ("studentData1")); //instantiate object
			for (int number = 0 ; number <studentCnt; number ++) //for loop to loop student through entries
			{ 
				output.println(S[number].getName()); //store entry name
				output.println(S[number].getHair()); //store entry hair
				output.println(S[number].getEye());//store entry eye
				output.println(S[number].getGender()); //store entry gender
				output.println(S[number].getGrade());//store entry grade
			}
			output.close (); //you must close the object to save the data in the studentData1 file
			System.out.println ("studentData1 file created with data!");
		}
		catch (Exception e)  ////need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch
		
		try //because the PrintWriter object can generate IO exceptions use the try and catch Blocks
		{
			PrintWriter output; //object to connect to a file
			output = new PrintWriter (new FileWriter ("interData1")); //instantiate object
			for (int number = 0 ; number <interStudentCnt; number ++) //for loop to loop through international student entries
			{ 
				output.println(I[number].getName()); //store entry name
				output.println(I[number].getHair()); //store entry hair
				output.println(I[number].getEye());//store entry eye
				output.println(I[number].getGender()); //store gender
				output.println(I[number].getGrade());//store entry grade
				output.println(I[number].getContinent());//store entry continent

			}

			output.close (); //you must close the object to save the data in the interData1 file
			System.out.println ("interData1 file created with data!");
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch 

		try //because the PrintWriter object can generate IO exceptions use the try and catch Blocks
		{
			PrintWriter output; //object to connect to a file
			output = new PrintWriter (new FileWriter ("teacherData1")); //instantiate object
			for (int number = 0 ; number <teacherCnt; number ++) //for loop to loop through teacher entries
			{ 
				output.println(T[number].getName()); //store entry name
				output.println(T[number].getHair()); //store entry hair
				output.println(T[number].getEye());//store entry eye
				output.println(T[number].getGender()); //store gender
				output.println(T[number].getSubject());//store entry subject

			}

			output.close (); //you must close the object to save the data in the teacherData1 file
			System.out.println ("teacherData1 file created with data!");
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch 
	}
	public void readCharacters() //method used to read contents of the file
	{
		try
		{
			numEntries =0;//numEntries equals 0
			BufferedReader input; //object to connect to file for read only
			input = new BufferedReader (new FileReader ("personData1"));
			String line= "";// line equals blank string
			line = input.readLine (); //variable line is equal to input.readline()
			String readName="", readHair = "", readEye="",readGender=""; //initializing String variables readName, readHair, readEye, readGender
			while (line != null) // while the line does not equal null
			{
				readName = line; //variable readName equals line
				//variables readHair, readEye, readGender and line equals input.readLine();
				readHair = input.readLine(); 
				readEye = input.readLine();
				readGender =input.readLine();
				P[numEntries] = new person (readName, readHair, readEye, readGender); //instantiating new object person for index numEntries
				comboBoxView.addItem(P[numEntries].getName());//adding name at index numEntries of person object to comboBoxView
				numEntries++;//adding one to numEntries
				line = input.readLine ();
			}
			input.close (); //close the file
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch
		
		try
		{
			studentCnt =0;//studentCnt equals 0
			BufferedReader input; //object to connect to file for read only
			input = new BufferedReader (new FileReader ("studentData1"));//writing to studentData1 file
			String line= "";// line equals blank string
			line = input.readLine (); //variable line is equal to input.readline()
			String readName="", readHair = "", readEye="",readGender="", readGrade=""; //initializing String variables readName, readHair, readEye, readGender, readGrade
			while (line != null) // while the line doesnt equal null
			{
				readName = line; //variable readName equals line
				//variables readHair, readEye, readGender, readGrade and line equals input.readLine();
				readHair = input.readLine(); 
				readEye = input.readLine();
				readGender =input.readLine();
				readGrade = input.readLine();
				S[studentCnt] = new student (readName, readHair, readEye, readGender, readGrade);//instantiating new object student for index studentCnt
				comboBoxView.addItem(S[studentCnt].getName());//adding name at index studentCnt of student object to comboBoxView
				studentCnt++;//adding one to studentCnt
				line = input.readLine ();
			}
			input.close (); //close the file
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch
		
		try
		{
			interStudentCnt =0;//interStudentCnt equals 0
			BufferedReader input; //object to connect to file for read only
			input = new BufferedReader (new FileReader ("interData1"));//writing to interData1 file
			String line= "";// line equals blank string
			line = input.readLine (); //variable line is equal to input.readline()
			String readName="", readHair = "", readEye="",readGender="", readGrade="", readContinent =""; //initializing String variables readName, readHair, readEye, readGender, readGrade, readContinent
			while (line != null) // while the line doesnt equal null
			{
				readName = line; //variable readName equals line
				//variables readHair, readEye, readGender, readGrade, readContinent and line equals input.readLine();
				readHair = input.readLine(); 
				readEye = input.readLine();
				readGender =input.readLine();
				readGrade = input.readLine();
				readContinent = input.readLine();
				I[interStudentCnt] = new international (readName, readHair, readEye, readGender, readGrade, readContinent);//instantiating new object international for index studentCnt
				comboBoxView.addItem(I[interStudentCnt].getName());//adding name at index interStudentCnt of international object to comboBoxView
				interStudentCnt++;//adding one to interStudentCnt
				line = input.readLine ();
			}
			input.close (); //close the file
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch
		
		try
		{
			teacherCnt =0;//teacherCnt equals 0
			BufferedReader input; //object to connect to file for read only
			input = new BufferedReader (new FileReader ("teacherData1"));//writing to teacherData1 file
			String line= "";// line equals blank string
			line = input.readLine (); //variable line is equal to input.readline()
			String readName="", readHair = "", readEye="",readGender="", readSubject=""; //initializing String variables readName, readHair, readEye, readGender, readSubject
			while (line != null) // while the line doesnt equal null
			{
				readName = line; //variable readName equals line
				//variables readHair, readEye, readGender, readSubject and line equals input.readLine();
				readHair = input.readLine(); 
				readEye = input.readLine();
				readGender =input.readLine();
				readSubject = input.readLine();
				T[teacherCnt] = new teacher (readName, readHair, readEye, readGender, readSubject);//instantiating new object teacher for index teacherCnt
				comboBoxView.addItem(T[teacherCnt].getName());//adding name at index teacherCnt of teacher object to comboBoxView
				teacherCnt++;//adding one to teacherCnt
				line = input.readLine ();
			}
			input.close (); //close the file
		}
		catch (Exception e)  //need this line for try catch
		{ //need this line for try catch
			System.out.println ("error");
		} //need this line for try catch
	}
}