# Memory

This Simulator has three memories:

* Data Memory
* Program Memory
* Stack Memory

---

### Data Memory

Data Memory is divided into Bank0 and Bank1

Each of them has 128 8-bit storage Addresses

located at 0x0C - 0x4F for Bank0 and 0x8c - 0xCF for Bank1

Access to Bank0 or Bank1 is controlled by the RP0-Flag in the Status Register

---

### Program Memory

Program Memory has storage for 1024 14-Bit Instructions

---

### Stack Memory

Stack Memory is a stack that holds the return addresses for if a sub-program is called (= GOTO, CALL, RETURN)

The stack is 8 addresses long and has a circular buffer behavior, so if it overflows, the oldest return-address gets overwritten