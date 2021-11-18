library  ieee;
use  ieee.std_logic_1164.all;

-- Full Adder

entity FULLADDER is
    port (
        a, b, c: in std_logic;
        sum, carry: out std_logic
    );

end FULLADDER;

architecture fulladder_behav of FULLADDER is
    begin
        sum <= (a xor b) xor c ;
        carry <= (a and b) or (c and (a xor b)
    );

end fulladder_behav;

-- 4-bit adder

library  ieee;
use  ieee.std_logic_1164.all;

entity FOURBITADD is
    port (
        a, b: in std_logic_vector(3 downto 0);
        Cin : in std_logic;
        sum: out std_logic_vector (3 downto 0);
        Cout, V: out std_logic
    );

end FOURBITADD;

architecture fouradder_structure of FOURBITADD is
    signal c: std_logic_vector (4 downto 0);
    component FULLADDER
        port(
            a, b, c: in std_logic;
            sum, carry: out std_logic
        );
            
    end component;

begin
    FA0: FULLADDER
        port map (a(0), b(0), Cin, sum(0), c(1));
    FA1: FULLADDER
        port map (a(1), b(1), C(1), sum(1), c(2));
    FA2: FULLADDER
        port map (a(2), b(2), C(2), sum(2), c(3));
    FA3: FULLADDER
        port map (a(3), b(3), C(3), sum(3), c(4));
    V <= c(3) xor c(4);
    Cout <= c(4);

end fouradder_structure;