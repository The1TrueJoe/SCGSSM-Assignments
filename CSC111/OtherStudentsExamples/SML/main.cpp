#include <iostream>
#include "../../SML/SymbolRow.h";
#include <vector>
#include <fstream>
#include <iterator>
#include <sstream>
using namespace std;


//Creating the 3 variables
int CurrentData = 99;
int CurrentPointer = 0;
int CurrentSYM = 0;


std::vector<std::string> tempCharHolder;
// Vector to temp hold the SML code that will be eventually written to a flie
vector <int> tempSMLHolder;

// Vector holding the go to things
vector <int> UnResolvedSymbols;


//Creating the SymbolTable
vector <SymbolRow> SymbolTable;

void SymTbl(string sym, string type, int loc) {
	//array of reserve words rem, input print it does not need to be in the table
	// array of acceptable charaters a-z all lower case
	// put the letter in for the sym and put type as "L" and loc = CurrentData
	//Add the symbol to the symbol tables
	// "20" or "x"
	SymbolTable.push_back(SymbolRow(sym, type, loc));
}



int Generate_SML_Command(int OpCode, int location) {

	string s1 = to_string(OpCode);
	string s2 = to_string(location);


	if (location < 10) {
		s2 = "0" + to_string(location);
	}


	string SML = s1 + s2;

	int code = stoi(SML);

	return code;
}


int Generate_SML_Command_For_GoTo(int OpCode, string location, vector<SymbolRow> row) {
	string opLocation;
	// First find location in table and store into a variable
	for (int i = 0; i < SymbolTable.size(); i++) {
		if (row[i].getSym() == location) {
			opLocation = to_string(row[i].getLoc());
		}
	}

	// turn op location into string and if less than 10 concate it with 0
	if (stoi(opLocation) < 10) {
		opLocation = "0" + opLocation;
	}

	string s1 = to_string(OpCode);

	string SML = s1 + opLocation;

	int code = stoi(SML);

	return code;

}


bool SymInTable(vector<SymbolRow> row, string sym) {
	for (int i = 0; i < SymbolTable.size(); i++) {
		if (row[i].getSym() == sym) {
			return true;
		}
	}
	return false;
}

int FindSymLoc(vector<SymbolRow> row, string sym) {
	for (int i = 0; i < SymbolTable.size(); i++) {
		if (row[i].getSym() == sym) {
			return row[i].getLoc();
		}
	}
}


int BranchesWithNoAddress(vector <int> tempSMLHolder) {
	int key1 = 40;
	int key2 = 41;
	int key3 = 42;

	bool found = false;

	for (int i = 0; i < tempSMLHolder.size(); i++)
	{
		if ((tempSMLHolder[i] == key1) || (tempSMLHolder[i] == key2) || (tempSMLHolder[i] == key3))
		{
			std::cout << "Element present at index " << i << endl;
			found = true;
			return i;
			break;
		}
	}
}

void SecondPass(vector<int> UnResolvedSymbols, vector<int> &tempSMLHolder, vector <SymbolRow> row) {

	for (int i = 0; i < UnResolvedSymbols.size(); i++) {
		if (UnResolvedSymbols[i] != -1) {
			// Then start the process of looking for the first thing that is just a 40, 41, 42 etc
			// store that
			int index = BranchesWithNoAddress(tempSMLHolder);
			cout << "Location at index " << index << endl;

			// Then look for the value of UnResolvedSymbols in row/SymbolRow vector and get its location
			int location = FindSymLoc(SymbolTable, to_string(UnResolvedSymbols[i]));
			location += 1;
			cout << location << endl;

			//Add location to the SML and push to the tempSMLHolder
			tempSMLHolder[index] = Generate_SML_Command(tempSMLHolder[index], location);
			cout << "The command generated " << Generate_SML_Command(tempSMLHolder[index], location) << endl;
			cout << "We running but nothing happening" << endl;
		}
	}
}



void Handle_Goto(string line, string gotoNum, vector<int> tempSMLGenerator, vector<SymbolRow> symbolTable, int BranchCommand) {
	if (stoi(gotoNum) > stoi(line)) {
		cout << "hi there" << endl;
		tempSMLHolder.push_back(Generate_SML_Command(4, -1));
		UnResolvedSymbols.push_back(stoi(gotoNum));
		SymTbl(line, "L", -1);
		CurrentSYM += 1;
	}
	else {
		// Implement it to deal with things that are above, this first cause easier??
		tempSMLHolder.push_back(Generate_SML_Command_For_GoTo(40, gotoNum, SymbolTable));
	}
}


void If_Statement_Generator(string line_num, string var1, string relop, string var2, string gotoLine, vector<int> &tempSMLHolder, vector<SymbolRow> SymbolTable) {
	// If statement for ==
	if (relop == "==") {

		cout << "Relop cout" << endl;

		if ((SymInTable(SymbolTable, var1) == true) && (SymInTable(SymbolTable, var2) == true)) {
			tempSMLHolder.push_back(Generate_SML_Command(20, FindSymLoc(SymbolTable, var1)));
			CurrentPointer += 1;
			tempSMLHolder.push_back(Generate_SML_Command(31, FindSymLoc(SymbolTable, var2)));
			CurrentPointer += 1;
			Handle_Goto(line_num, gotoLine, tempSMLHolder, SymbolTable, 420);
		}
		else {
			cout << "Error, variable does not exist" << endl;
		}
	}

	// If statement for >

	// If statement for <

	// If statement for >=

	// If statment for <=

	// If statment for !=
}


void SML_Generator(vector<string> Command) {
	// All start by looking at command [1] to see keyword
	// If key word rem, then look at Command[0] and add that to symbol table
	if (Command[1] == "rem") {
		SymTbl(Command[0], "L", CurrentPointer);
		CurrentSYM += 1;
		UnResolvedSymbols.push_back(-1);
	}

	// If key word input, then look at Command[0] and add that to symbol table with instruction pointer and SML
	// than look at Command [2] and add to symbol table
	if (Command[1] == "input") {
		// Make sure there is no other x or whatever var is in the symtbl
		if (!SymInTable(SymbolTable, Command[2])) {
			// Generate SML code and then add the line number and var to symtbl
			SymTbl(Command[0], "L", CurrentPointer);
			CurrentPointer += 1;
			CurrentSYM += 1;
			UnResolvedSymbols.push_back(-1);
			//Adding var to symtbl
			tempSMLHolder.push_back(Generate_SML_Command(10, CurrentData));
			SymTbl(Command[2], "V", CurrentData);
			CurrentData -= 1;
			CurrentSYM += 1;
			UnResolvedSymbols.push_back(-1);
		}
		else {
			cout << "Variable already declared" << endl;
		}
	}

	// If keyword print, look at at Command[0] and add that to instruction table with the updated instruction pointer and SML
	if (Command[1] == "print") {
		if (!SymInTable(SymbolTable, Command[2])) {
			cout << "Var you trying to get " << Command[2] << " does not exist" << endl;
		}
		else {
			// Find the symtbl row and generate SML
			tempSMLHolder.push_back(Generate_SML_Command(11, FindSymLoc(SymbolTable, Command[2])));
			SymTbl(Command[0], "L", CurrentPointer);
			CurrentPointer += 1;
			UnResolvedSymbols.push_back(-1);
		}
	}


	if (Command[1] == "goto") {

		cout << stoi(Command[2]) << endl;

		Handle_Goto(Command[0], Command[2], tempSMLHolder, SymbolTable, 40);

		/*
		if (stoi(Command[2]) > stoi(Command[0])) {
			cout << "hi there" << endl;
			tempSMLHolder.push_back(Generate_SML_Command(4, -1));
			UnResolvedSymbols.push_back(stoi(Command[2]));
			SymTbl(Command[0], "L", -1);
			CurrentSYM += 1;
		}
		else {
			// Implement it to deal with things that are above, this first cause easier??
			tempSMLHolder.push_back(Generate_SML_Command_For_GoTo(40, Command[2], SymbolTable));
		}
		*/
	}

	if (Command[1] == "if") {
		cout << "If statement relop" << endl;
		If_Statement_Generator(Command[0], Command[2], Command[3], Command[4], Command[6], tempSMLHolder, SymbolTable);
	}

	if (Command[1] == "end") {
		tempSMLHolder.push_back(Generate_SML_Command(43, 00));
		SymTbl(Command[0], "L", CurrentPointer);
		CurrentPointer += 1;
		CurrentSYM += 1;
	}

}


//Functions that are needed to split string by whitespaces
template <typename Out>
void split(const std::string& s, char delim, Out result) {
	std::istringstream iss(s);
	std::string item;
	while (std::getline(iss, item, delim)) {
		*result++ = item;
	}
}

std::vector<std::string> split(const std::string& s, char delim) {
	std::vector<std::string> elems;
	split(s, delim, std::back_inserter(elems));
	return elems;
}


void SML_Writer(string command) {
	// Break up the command by whitespace
	tempCharHolder.clear();
	tempCharHolder = split(command, ' ');
	SML_Generator(tempCharHolder);
}


int main() {

	ifstream file("Text.txt");

	// Reads it line by line and returns the line pass this into SML code generator function, a function which has the line parser and table adder
	if (file.is_open()) {
		std::string line;
		while (std::getline(file, line)) {
			SML_Writer(line);
		}

		file.close();
	}

	for (int z = 0; z < tempSMLHolder.size(); z++) {
		cout << tempSMLHolder[z] << endl;
	}

	cout << "---------------------------------------" << endl;


	for (int x = 0; x < UnResolvedSymbols.size(); x++) {
		cout << UnResolvedSymbols[x] << endl;
	}

	SecondPass(UnResolvedSymbols, tempSMLHolder, SymbolTable);

	cout << "---------------------------------------" << endl;

	for (int z = 0; z < tempSMLHolder.size(); z++) {
		cout << tempSMLHolder[z] << endl;
	}


	//Giant if statement we read between the white spaces
	//Read 20 and put in table
	//read input or command trigger if function write the SML code to output to SML file
	// read the actual symbol if there is another

	// We use what the above outputted throw into a switch case and go from there

	return 0;
}