#include <iostream>
#include <string>

using namespace std;

class SymbolRow {
public:
	SymbolRow(string, string, int);

	string getSymbol();

	string getType();

	int getLocation();

	void setSymbol(string);

	void setType(string);

	void setLocation(int);

private:
	string symbol;

	string type;

	int location;

};