#include "SymbolRow.h";
#include <iostream>

/**
 * @brief Construct a new Symbol Row:: Symbol Row object
 * 
 * @param my_sym 
 * @param my_type 
 * @param my_location 
 */

SymbolRow::SymbolRow (string my_sym, string my_type, int my_location) {
	setSymbol(my_sym);
	setType(my_type);
	setLocation(my_location);
}

/**
 * @brief set the symbol
 * 
 * @param my_sym set the symbol
 */

void SymbolRow::setSymbol(string my_sym) {
	symbol = my_sym;
}

/**
 * @brief set the type
 * 
 * @param my_type set the type
 */

void SymbolRow::setType(string my_type) {
	type = my_type;
}

/**
 * @brief set the location
 * 
 * @param my_location set the location
 */

void SymbolRow::setLocation(int my_location) {
	location = my_location;
}

/**
 * @brief return symbol 
 * 
 * @return symbol 
 */

string SymbolRow::getSymbol() {
	return symbol;
}

/**
 * @brief return operation type 
 * 
 * @return operation type 
 */

string SymbolRow::getType() {
	return type;
}

/**
 * @brief return operation location
 * 
 * @return operation location
 */

int SymbolRow::getLocation() {
	return location;
}