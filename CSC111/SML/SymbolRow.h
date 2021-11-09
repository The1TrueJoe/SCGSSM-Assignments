#include <iostream>
#include <string>

using namespace std;

class SymbolRow {
public:
	// constructor
	SymbolRow(string, string, int);

	// set symbol
	string getSymbol();

	// set type
	string getType();

	// set location
	int getLocation();

	// set symbol
	void setSymbol(string);

	// set type
	void setType(string);

	// set location
	void setLocation(int);

private:
	// symbol
	string symbol;

	// type
	string type;

	// location
	int location;

};