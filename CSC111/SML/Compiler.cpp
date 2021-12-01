#include <iostream>
#include <vector>
#include <fstream>
#include <iterator>
#include <sstream>

#include "SymbolRow.h"
#include "CPU.h"

using namespace std;

//
int current_data = 99;
//
int current_pointer = 0;
//
int current_sym = 0;

//
vector<string> chars;
//
vector <int> sml_code;
//
vector <int> unresolved_symbols;
//
vector <SymbolRow> symbol_table;
//
vector <int> temp_sml;



// ----------- Symbol Table Utils -----------

/**
 * @brief Inserts new symbol row at the end of the symbol table
 * 
 * @param symbol Symbol table symbol
 * @param type Symbol type
 * @param location Memory location
 */

void insertIntoSymTable(string symbol, string type, int location) {
	symbol_table.push_back(SymbolRow(symbol, type, location));

}

/**
 * @brief Get the location of the symbol
 * 
 * @param row Symbol Table row
 * @param symbol Symbol Row Symbol
 * 
 * @return int the location
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
 * @brief Check if the symbol is inserted into the table
 * 
 * @param row Symbol Table row
 * @param symbol Symbol Row symbol
 * 
 * @return true if the symbol is in the symbol table
 * @return false if the symbol is not in the symbol table
 */

bool wasSymInserted(vector<SymbolRow> row, string symbol) {
	for (int i = 0; i < symbol_table.size(); i++) {
		if (row[i].getSymbol() == symbol) {
			return true;

		}
	}

	return false;
}

// ----------- String Utils -----------

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

// ----------- SML Command Utils -----------

/**
 * @brief Formats the command into the SML style
 * 
 * @param op_code op code
 * @param location memory location
 * 
 * @return int 
 */

int formatCommand(int op_code, int location) {
	string loc = to_string(location);
	if (location < 10) { loc = "0" + to_string(location);}

	return stoi(to_string(op_code) + loc);

}

// ----------- Not -----------

/**
 * @brief 
 * 
 * @param command 
 * @return true 
 * @return false 
 */

bool notOp(string command) {
	bool found = true;

	// Expand the list later
	const int size = 5;
	string legalVar[size] = { "*", "+", "-", "/" };
	for (int i = 0; i < size; i++) {
		if (legalVar[i] == command) {
			found = false;
			return found;

		}
	}

	return found;
}

/**
 * @brief 
 * 
 * @param command 
 * @return true 
 * @return false 
 */

bool notVar(string command) {
	bool found = true;

	// Expand the list later
	const int size = 5;
	string legalVar[size] = { "x", "y", "z", "b", "a"};
	for (int i = 0; i < size; i++) {
		if (legalVar[i] == command) {
			found = false;
			return found;
		}
	}

	return found;
}

// ----------- Infix to Postfix -----------

/**
 * @brief Check operator precedence
 * 
 * @param c operator
 * 
 * @return precedence
 */

int precedence(char c) {
	if (c == '^')
		return 3;
	else if (c == '/' || c == '*')
		return 2;
	else if (c == '+' || c == '-')
		return 1;
	else
		return -1;

}

/**
 * @brief convert infix to postfix
 * 
 * @param string string in infix
 * 
 * @return the string converted to postfix
 */

string infixToPostfix(string s) {
	stack<char> st; 
	string result;

	for (int i = 0; i < s.length(); i++) {
		char c = s[i];
		
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
			result = result + c + " ";

		
		} else if (c == '(') {
			st.push('(');

		
		} else if (c == ')') {
			while (st.top() != '(') {
				result = result + st.top() + " ";
				st.pop();
			}

			st.pop();

		} else {
			while (!st.empty() && precedence(s[i]) <= precedence(st.top())) {
				result = result + st.top() + " ";
				st.pop();
			}

			st.push(c);

		}
	}

	
	while (!st.empty()) {
		result = result + st.top() + " ";
		st.pop();

	}

	return result;

}

// ----------- GOTOs -----------

/**
 * @brief Makr the goto command
 * 
 * @param op_code The op code
 * @param location Goto location
 * @param row Symbol table row
 * 
 * @return int SML command
 */

int makeGoto(int op_code, string location, vector<SymbolRow> row) {
	string op_location;
	
	for (int i = 0; i < symbol_table.size(); i++) {
		if (row[i].getSymbol() == location) {
			op_location = to_string(row[i].getLocation());

		}
	}

	return formatCommand(op_code, stoi(op_location));

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
		sml_code.push_back(formatCommand(4, -1));
		unresolved_symbols.push_back(stoi(goto_num));

		insertIntoSymTable(line, "L", -1);

		current_sym += 1;

	} else {
		sml_code.push_back(makeGoto(40, goto_num, symbol_table));

	}
}

// ----------- IFs -----------

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

void doIf(string line_num, string var1, string relop, string var2, string goto_line, vector<int> &temp_sml, vector<SymbolRow> symbol_table) {
	// If statement for ==
	if (relop == "==") {
		cout << "Relop cout" << endl;

		if ((wasSymInserted(symbol_table, var1) == true) && (wasSymInserted(symbol_table, var2) == true)) {
			temp_sml.push_back(formatCommand(CPU::LOAD, getSymLocation(symbol_table, var1)));
			current_pointer += 1;

			temp_sml.push_back(formatCommand(CPU::SUB, getSymLocation(symbol_table, var2)));
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 42);
			current_pointer += 1;

		} else {
			cout << "Error, variable does not exist" << endl;

		}
	}

	// If statement for <
	if (relop == "<") {
		if ((wasSymInserted(symbol_table, var1) == true) && (wasSymInserted(symbol_table, var2) == true)) {
			temp_sml.push_back(formatCommand(CPU::LOAD, getSymLocation(symbol_table, var1)));
			current_pointer += 1;

			temp_sml.push_back(formatCommand(CPU::SUB, getSymLocation(symbol_table, var2)));
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 41);
			current_pointer += 1;

		} else {
			cout << "Error, variable does not exist" << endl;

		}
	}

	// If statement for >
	if (relop == ">" || relop == ">=") {
		if ((wasSymInserted(symbol_table, var1) == true) && (wasSymInserted(symbol_table, var2) == true)) {
			temp_sml.push_back(formatCommand(CPU::LOAD, getSymLocation(symbol_table, var1)));
			current_pointer += 1;

			temp_sml.push_back(formatCommand(CPU::SUB, getSymLocation(symbol_table, var2)));
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 41);
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 40);
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 42);
			current_pointer += 1;

		} else {
			cout << "Error, variable does not exist" << endl;

		}
	}

	// If statement for <=
	if (relop == "<=") {
		if ((wasSymInserted(symbol_table, var1) == true) && (wasSymInserted(symbol_table, var2) == true)) {
			temp_sml.push_back(formatCommand(CPU::LOAD, getSymLocation(symbol_table, var1)));
			current_pointer += 1;

			temp_sml.push_back(formatCommand(CPU::SUB, getSymLocation(symbol_table, var2)));
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 41);
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 42);
			current_pointer += 1;

		} else {
			cout << "Error, variable does not exist" << endl;

		}
	}

	// If statment for !=
	if (relop == "!=") {
		if ((wasSymInserted(symbol_table, var1) == true) && (wasSymInserted(symbol_table, var2) == true)) {
			temp_sml.push_back(formatCommand(CPU::LOAD, getSymLocation(symbol_table, var1)));
			current_pointer += 1;

			temp_sml.push_back(formatCommand(CPU::SUB, getSymLocation(symbol_table, var2)));
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 41);
			current_pointer += 1;

			doGoto(line_num, goto_line, temp_sml, symbol_table, 40);
			current_pointer += 1;

		} else {
			cout << "Error, variable does not exist" << endl;

		}
	}
}

// ----------- Let -----------

/**
 * @brief 
 * 
 * @param equation 
 * @param temp_sml 
 * @param symbol_table 
 * @param memory_location 
 */

void doEquation(string equation, vector<int>& temp_sml, vector<SymbolRow> symbol_table, int memory_location) {
	string s = infixToPostfix(equation);

	string space_delimiter = " ";
	vector<string> EquationSymbol{};

	size_t pos = 0;
	while ((pos = s.find(space_delimiter)) != string::npos) {
		EquationSymbol.push_back(s.substr(0, pos));
		s.erase(0, pos + space_delimiter.length());
	}

	int stackpointer = current_data;
	for (int i = 0; i < EquationSymbol.size(); i++) {
		cout << EquationSymbol[i] << endl;
		if (notOp(EquationSymbol[i]) == false) {
			cout << "evaluvating operator" << endl;

			stackpointer += 1;
			temp_sml.push_back(formatCommand(CPU::LOAD, stackpointer));
			
			stackpointer += 1;

			switch (opSwitch(EquationSymbol[i])) {
				case 0:
					temp_sml.push_back(formatCommand(CPU::MULT, stackpointer));
					break;

				case 1:
					temp_sml.push_back(formatCommand(CPU::DIV, stackpointer));
					break;

				case 2:
					temp_sml.push_back(formatCommand(CPU::ADD, stackpointer));
					break;

				case 3:
					temp_sml.push_back(formatCommand(CPU::SUB, stackpointer));
					break;
			
				default:
					break;
			}

			temp_sml.push_back(formatCommand(CPU::STORE, stackpointer));
			stackpointer -= 1;

		} else {
			if (notVar(EquationSymbol[i]) == true) {
				temp_sml.push_back(formatCommand(22, stoi(EquationSymbol[i])));
				
				
			} else {
				temp_sml.push_back(formatCommand(CPU::LOAD, getSymLocation(symbol_table, EquationSymbol[i])));
				
			}

			current_pointer += 1;
			temp_sml.push_back(formatCommand(CPU::STORE, stackpointer));

			current_pointer += 1;
			current_data -= 1;
			stackpointer -= 1;

		}
	}

	temp_sml.push_back(formatCommand(CPU::LOAD, (stackpointer + 1)));
	current_pointer += 1;

	temp_sml.push_back(formatCommand(CPU::STORE, memory_location));
	current_pointer += 1;
	
}

/**
 * @brief 
 * 
 * @param symbol 
 * @return int 
 */

int opSwitch(string symbol) {
	switch (symbol[0]) {
		case '*':
			return 0;

		case '/':
			return 1;

		case '+':
			return 2;

		case '-':
			return 3;

		default:
			return -1;
	}
}

// ----------- Branches -----------

/**
 * @brief Counte number of branches that point nowhere
 * 
 * @param sml_code code
 * 
 * @return int number of branches that point nowhere
 */

int checkBranchesNoPointer(vector <int> sml_code) {
	for (int i = 0; i < sml_code.size(); i++) {
		if ((sml_code[i] == CPU::BRANCH) || (sml_code[i] == CPU::BRANCHNEG) || (sml_code[i] == CPU::BRANCHZERO)) {
			cout << "Element at " << i << endl;
			
            return i;

		}
	}

    return 0;

}

// ----------- Second Pass -----------

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
			int index = checkBranchesNoPointer(sml_code);
			cout << "Location: " << index << endl;

			int location = getSymLocation(symbol_table, to_string(unresolved_symbols[i]));
			location += 1;
			cout << location << endl;

			sml_code[index] = formatCommand(sml_code[index], location);
			cout << "Command: " << formatCommand(sml_code[index], location) << endl;
			cout << "Nothing running" << endl;

		}
	}
}



/**
 * @brief 
 * 
 * @param command 
 */

void smlGen(vector<string> Command) {
	
	if (Command[1] == "rem") {
		insertIntoSymTable(Command[0], "L", current_pointer);
		current_sym += 1;
		unresolved_symbols.push_back(-1);

	}

	if (Command[1] == "end") {
		temp_sml.push_back(formatCommand(CPU::HALT, 00));

		insertIntoSymTable(Command[0], "L", current_pointer);
		current_pointer += 1;
		current_sym += 1;
	}

	if (Command[1] == "goto") {
		cout << stoi(Command[2]) << endl;

		doGoto(Command[0], Command[2], temp_sml, symbol_table, 40);
		insertIntoSymTable(Command[0], "L", -1);

		current_sym += 1;
		current_data += 1;

	}

	if (Command[1] == "input") {
		if (!wasSymInserted(symbol_table, Command[2])) {
			insertIntoSymTable(Command[0], "L", current_pointer);

			current_pointer += 1;
			current_sym += 1;

			unresolved_symbols.push_back(-1);
			temp_sml.push_back(formatCommand(CPU::READ, current_data));

			insertIntoSymTable(Command[2], "V", current_data);

			current_data -= 1;
			current_sym += 1;

			unresolved_symbols.push_back(-1);

		} else {
			cout << "Variable already declared" << endl;

		}
	}

	if (Command[1] == "let") {
		if (wasSymInserted(symbol_table, Command[2])) {
			doEquation(Command[4], temp_sml, symbol_table, getSymLocation(symbol_table, Command[2]));

		} else {
			insertIntoSymTable(Command[2], "V", current_data);
			current_data -= 1;
			current_sym += 1;

			unresolved_symbols.push_back(-1);

			doEquation(Command[4], temp_sml, symbol_table, getSymLocation(symbol_table, Command[2]));

		}
	}

	if (Command[1] == "print") {
		if (!wasSymInserted(symbol_table, Command[2])) {
			cout << "Var you trying to get " << Command[2] << " does not exist" << endl;

		} else {
			temp_sml.push_back(formatCommand(CPU::WRITE, getSymLocation(symbol_table, Command[2])));

			insertIntoSymTable(Command[0], "L", current_pointer);
			current_pointer += 1;

			unresolved_symbols.push_back(-1);

		}
	}

	if (Command[1] == "if") {
		if (notVar(Command[4]) == true) {
			cout << "Literal Statement in here " << endl;

			temp_sml.push_back(formatCommand(22, stoi(Command[4])));
			current_pointer += 1;

			temp_sml.push_back(formatCommand(CPU::STORE, current_data));
			current_pointer += 1;

			insertIntoSymTable(Command[4], "C", current_data);
			current_data -= 1;
			current_sym += 1;
			
		}
		
		cout << "If statement relop" << endl;
		doIf(Command[0], Command[2], Command[3], Command[4], Command[6], temp_sml, symbol_table);

	}

	for (int z = 0; z < temp_sml.size(); z++) {
		cout << temp_sml[z] << endl;

	}
}