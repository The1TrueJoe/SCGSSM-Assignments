#include "SymbolRow.h";
#include <iostream>

SymbolRow::SymbolRow (string my_sym, string my_type, int my_location) {
	setSymbol(my_sym);
	setType(my_type);
	setLocation(my_location);
}

void SymbolRow::setSymbol(string my_sym) {
	symbol = my_sym;
}

void SymbolRow::setType(string my_type) {
	type = my_type;
}

void SymbolRow::setLocation(int my_location) {
	location = my_location;
}

string SymbolRow::getSymbol() {
	return symbol;
}

string SymbolRow::getType() {
	return type;
}

int SymbolRow::getLocation() {
	return location;
}