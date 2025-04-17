# INSTRUCTIONS

Instructions are saved in a file with the extension .LST

They get encoded in 14-Bit OpCode instructions

There are three kinds of instructions:

* Byte Oriented
* Bit Oriented
* Literal

---

### OpCode Field Descriptions

| Field | Description |
| :----:| :------|
| f | Register File Address (0x00 to 0x7F)|
| W | Working Register (accumulator)|
| b | Bit address within an 8-bit file register|
| k | Literal field, constant data|
| x | Don't Care location (= 0 or 1)|
| d | Destination select (0 = W, 1 = f)|


### Byte Oriented

| Operand | Description | 14-Bit OpCode |
| :-------: | ----------- | :------------- |
| ADDWF   | Add W and f | 00 0111 dfff ffff |
| ANDWF   | AND W with f| 00 0101 dfff ffff |
| CLRF    | Clear f     | 00 0001 1fff ffff |
| CLRW    | Clear W     | 00 0001 0xxx xxxx |
| COMF    | Complement f| 00 1001 dfff ffff |
| DECF    | Decrement f | 00 0011 dfff ffff |
| DECFSZ  | Decrement f skip if zero| 00 1011 dfff ffff|
| INCF    | Increment f | 00 1010 dfff ffff |
| INCFSZ  | Increment f skip if zero| 00 1111 dfff ffff|
| IORWF   | Inclusive OR W with f| 00 0100 dfff ffff|
| MOVF    | Move f      | 00 1000 dfff ffff |
| MOVWF   | Move W to f | 00 0000 1fff ffff |
| NOP     | No Operation| 00 0000 0xx0 0000 |
| RLF     | Rotate Left f| 00 1101 dfff ffff|
| RRF     |Rotate Right f| 00 1100 dfff ffff|
| SUBWF   | Subtract W from f| 00 0010 dfff ffff|
| SWAPF   | Swap nibbles in f| 00 1110 dfff ffff|
| XORWF   | Exclusive OR W with f| 00 0110 dfff ffff|

### Bit Oriented

| Operand | Description | 14-Bit OpCode |
| :-------: | ----------- | :------------- |
| BCF | Bit Clear f | 01 00bb bfff ffff |
| BSF | Bit Set f   | 01 01bb bfff ffff |
| BTFSC| Bit Test f Skip if Clear| 01 10bb bfff ffff|
| BTFSS| Bit Test f Skip if Set| 01 11bb bfff ffff|

### Literal

| Operand | Description | 14-Bit OpCode |
| :-------: | ----------- | :------------- |
| ADDLW | Add literal and W| 11 111x kkkk kkkk|
| ANDLW | AND literal with W| 11 1001 kkkk kkkk|
| CALL  | Call subroutine | 10 0kkk kkkk kkkk|
| CLRWDT| Clear Watchdog Timer| 00 0000 0110 01000|
| GOTO  | Go to address | 10 1kkk kkkk kkkk|
| IORLW | Inclusive OR literal with W| 11 1000 kkkk kkkk|
| MOVLW | Move literal to W| 11 00xx kkkk kkkk|
| RETFIE| Return from interrupt| 00 0000 0000 1001|
| RETLW | Return with literal in W| 11 01xx kkkk kkkk|
| RETURN| Return from subroutine | 00 0000 0000 1000|
| SLEEP | Go into standby mode| 00 0000 0110 0011|
| SUBLW | Subtract W from literal| 11 110x kkkk kkkk|
| XORLW | Exclusive OR literal with W| 11 1010 kkkk kkkk|