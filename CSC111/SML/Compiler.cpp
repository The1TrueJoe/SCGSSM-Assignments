#include <iostream>
#include <vector>
#include <fstream>
#include <iterator>
#include <sstream>

#include "SymbolRow.h";

using namespace std;

int current_data = 99;
int current_pointer = 0;
int current_sym = 0;

vector<string> chars;
vector <int> sml_code;
vector <int> unresolved_symbols;

vector <SymbolRow> symbol_table;

/**
 * @brief 
 * 
 * @param symbol 
 * @param type 
 * @param location 
 */

void symbolTable(string symbol, string type, int location) {
	symbol_table.push_back(SymbolRow(symbol, type, location));

}

/**
 * @brief 
 * 
 * @param op_code 
 * @param location 
 * 
 * @return int 
 */

int makeCommand(int op_code, int location) {
	string s1 = to_string(op_code);
	string s2 = to_string(location);

	if (location < 10) {
		s2 = "0" + to_string(location);

	}

	string SML = s1 + s2;
	int code = stoi(SML);

	return code;

}

/**
 * @brief 
 * 
 * @param op_code 
 * @param location 
 * @param row 
 * 
 * @return int 
 */

int makeGoto(int op_code, string location, vector<SymbolRow> row) {
	string op_location;
	
	for (int i = 0; i < symbol_table.size(); i++) {
		if (row[i].getSymbol() == location) {
			op_location = to_string(row[i].getLocation());

		}
	}

	if (stoi(op_location) < 10) {
		op_location = "0" + op_location;

	}

	string s1 = to_string(op_code);
	string SML = s1 + op_location;
	int code = stoi(SML);

	return code;

}

/**
 * @brief 
 * 
 * @param row 
 * @param symbol 
 * @return true 
 * @return false 
 */

bool checkSymbolTable(vector<SymbolRow> row, string symbol) {
	for (int i = 0; i < symbol_table.size(); i++) {
		if (row[i].getSymbol() == symbol) {
			return true;

		}
	}

	return false;
}

/**
 * @brief 
 * 
 * @param row 
 * @param symbol 
 * 
 * @return int 
 */

int getSymLocation(vector<SymbolRow> row, string symbol) {
	for (int i = 0; i < symbol_table.size(); i++) {
		if (row[i].getSymbol() == symbol) {
			return row[i].getLocation();

		}
	}

    return 0;
}

/**
 * @brief 
 * 
 * @param sml_code 
 * 
 * @return int 
 */

int branchesWithNoAddress(vector <int> sml_code) {
	int key1 = 40;
	int key2 = 41;
	int key3 = 42;

	bool found = false;

	for (int i = 0; i < sml_code.size(); i++) {
		if ((sml_code[i] == key1) || (sml_code[i] == key2) || (sml_code[i] == key3)) {
			cout << "Element at " << i << endl;
			
            found = true;
            return i;

		}
	}

    return 0;

}

/**
 * @brief 
 * 
 * @param unresolved_symbols 
 * @param sml_code 
 * @param row 
 */

void secondPass(vector<int> unresolved_symbols, vector<int> &sml_code, vector <SymbolRow> row) {

	for (int i = 0; i < unresolved_symbols.size(); i++) {
		if (unresolved_symbols[i] != -1) {
			int index = branchesWithNoAddress(sml_code);
			cout << "Location: " << index << endl;

			int location = getSymLocation(symbol_table, to_string(unresolved_symbols[i]));
			location += 1;
			cout << location << endl;

			sml_code[index] = makeCommand(sml_code[index], location);
			cout << "command: " << makeCommand(sml_code[index], location) << endl;
			cout << "Nothing running" << endl;

		}
	}
}

/**
 * @brief 
 * 
 * @param line 
 * @param goto_num 
 * @param temp_smlgen 
 * @param symbol_table 
 * @param branch_command 
 */

void doGoto(string line, string goto_num, vector<int> temp_smlgen, vector<SymbolRow> symbol_table, int branch_command) {
	if (stoi(goto_num) > stoi(line)) {
		sml_code.push_back(makeCommand(4, -1));
		unresolved_symbols.push_back(stoi(goto_num));
		symbolTable(line, "L", -1);
		current_sym += 1;

	} else {
		sml_code.push_back(makeGoto(40, goto_num, symbol_table));

	}
}

/**
 * @brief 
 * 
 * @param line_num 
 * @param var1 
 * @param relop 
 * @param var2 
 * @param goto_line 
 * @param sml_code 
 * @param symbol_table 
 */

void ifstatement(string line_num, string var1, string relop, string var2, string goto_line, vector<int> &sml_code, vector<SymbolRow> symbol_table) {
	if (relop == "==") {

		cout << "Relop cout" << endl;

		if ((checkSymbolTable(symbol_table, var1) == true) && (checkSymbolTable(symbol_table, var2) == true)) {
			sml_code.push_back(makeCommand(20, getSymLocation(symbol_table, var1)));
			current_pointer += 1;

			sml_code.push_back(makeCommand(31, getSymLocation(symbol_table, var2)));
			current_pointer += 1;

			doGoto(line_num, goto_line, sml_code, symbol_table, 420);
		} else {
			cout << "Error, var dne";

		}
	}

}

/**
 * @brief 
 * 
 * @param command 
 */

void smlGen(vector<string> command) {
	if (command[1] == "rem") {
		symbolTable(command[0], "L", current_pointer);
		current_sym += 1;
		unresolved_symbols.push_back(-1);

	}

	if (command[1] == "input") {
		if (!checkSymbolTable(symbol_table, command[2])) {
			
			symbolTable(command[0], "L", current_pointer);
			current_pointer += 1;
			current_sym += 1;
			unresolved_symbols.push_back(-1);
			
            
			sml_code.push_back(makeCommand(10, current_data));
			symbolTable(command[2], "V", current_data);
			current_data -= 1;
			current_sym += 1;
			unresolved_symbols.push_back(-1);
		} else {
			cout << "Variable already declared" << endl;

		}
	}

	if (command[1] == "print") {
		if (!checkSymbolTable(symbol_table, command[2])) {
			cout << command[2] << " dne" << endl;

		} else {
			sml_code.push_back(makeCommand(11, getSymLocation(symbol_table, command[2])));
			symbolTable(command[0], "L", current_pointer);
			current_pointer += 1;
			unresolved_symbols.push_back(-1);

		}
	}


	if (command[1] == "goto") {
		cout << stoi(command[2]) << endl;
		doGoto(command[0], command[2], sml_code, symbol_table, 40);

	} 
    
    if (command[1] == "if") {
		cout << "If statement relop" << endl;
		ifstatement(command[0], command[2], command[3], command[4], command[6], sml_code, symbol_table);

	}

	if (command[1] == "end") {
		sml_code.push_back(makeCommand(43, 00));
		symbolTable(command[0], "L", current_pointer);
		current_pointer += 1;
		current_sym += 1;

	}

}

/**
 * @brief 
 * 
 * @tparam Out 
 * 
 * @param s 
 * @param delim 
 * @param result 
 */

template <typename Out>
void split(const string& s, char delim, Out result) {
	istringstream iss(s);
	string item;

	while (getline(iss, item, delim)) {
		*result++ = item;

	}
}

/**
 * @brief 
 * 
 * @param s 
 * @param delim 
 * 
 * @return vector<string> 
 */

vector<string> split(const string& s, char delim) {
	vector<string> elems;
	split(s, delim, back_inserter(elems));
	return elems;

}

/**
 * @brief 
 * 
 * @param command 
 */

void smlWriter(string command) {
	chars.clear();
	chars = split(command, ' ');
	smlGen(chars);

}

/**
 * @brief 
 * 
 * @return int 
 */

int main() {
	ifstream file("Text.txt");

	if (file.is_open()) {
		string line;

		while (getline(file, line)) {
			smlWriter(line);

		}

		file.close();
	}

	for (int z = 0; z < sml_code.size(); z++) {
		cout << sml_code[z] << endl;

	}

	cout << "---------------------------------------" << endl;


	for (int x = 0; x < unresolved_symbols.size(); x++) {
		cout << unresolved_symbols[x] << endl;

	}

	secondPass(unresolved_symbols, sml_code, symbol_table);

	cout << "---------------------------------------" << endl;

	for (int z = 0; z < sml_code.size(); z++) {
		cout << sml_code[z] << endl;

	}

	return 0;
}