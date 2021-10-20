void swapVar(int &a, int &b){
    int c = a;
    a = b;
    b = a;

}

int main () {
    int a;
    int b;

    cout << "Enter two numbers " << endl;
    cin >> a >> b;

    swapVar(a, b);

    cout << a << endl;
    cout << b << endl;

}