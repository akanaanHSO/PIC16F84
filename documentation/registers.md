# Registers

This simulator has around 9 Registers

* Instruction Register
* PortA / PortB
* TrisA / TrisB
* Program Counter
* Status Register
* Working Register

---

### Instruction Register

Instruction Register is a 14-Bit Register

It stores the current 14-Bit Instruction fetched from the Program Memory, which is then decoded by the decoder

---

### PortA / PortB

The PIC16F8X has two ports, PORTA and PORTB.
Some port pins are multiplexed with an alternate function
for other features on the device.

---

### TrisA / TrisB

Tris Controls the direction of the Port Pins (Input or Output)

---

### Program Counter

Program Counter is a 13-Bit register that holds the address of the next instruction, Addresses are 10-bit long (0x000 - 0x3FF)

The Low Byte is the PCL register (readable and writable)

The High Byte is the PCLATH register (not directly readable nor writable)

---

### Status Register

The Statis Register is a 8-Bit register which stores the flag-states of the status bits

* C Carry/Borrow Bit
* DC Digit Carry/Borrow Bit
* Z Zero Bit
* PD Power-Down Bit
* TO Time-out Bit
* RP1:RP0 Register Bank Select Bits
* IRP Register Bank Select Bits for Indirect Addressing

#### Carry/Borow Bit

Status-Bit 0 is set to 1 if at the last operation a carry-out from the most significant bit of the operation resulted and 0 if not

#### Digit Carry/Borrow Bit

Status-Bit 1 is set to 1 if a carry-out from the 4th low order bit of the result occured and 0 if not

#### Zero Bit

Status-Bit 2 is set to 1 if the result of the last operation is zero and 0 if it is not zero

#### Power-down Bit

Status-Bit 3 is set to 1 after power-up or by the CLRWDT instruction

#### Time-out Bit

Status-Bit 4 is set to 1 after power-up, CLRWDT instruction or SLEEP instruction

#### RP1:RP0 Register Bank Select Bits

Status-Bits 5 and 6 decide, which Register-Bank will be addressed

* 00 - Bank0
* 01 - Bank1
* 10 - Bank2
* 11 - Bank3

PIC16F8x uses only RP0

#### IRP Register Bank Select Bits 

Unused by PIC16F8x

---

### Working Register

The Working Register is a 8-Bit register which stores the data currently being manipulated by the ALU

It can also store the intermediate results of the operations