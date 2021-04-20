import string


class TestClass:

    sys_choice = ""

    def __init__(self, sys_choice):
        self.sys_choice = sys_choice

    def choice(self, system: string):
        if system.upper() != "WINDOWS" or system.upper() != "LINUX":
            return system + " isn't a right parameter (windows or linux is suitable)"

    def name(self, a):
        a = a + self.sys_choice
        return a

    def method(self):
        return self.name(1)


print(TestClass(1).method())

# {
#     'wartosc': 'parametr1',
#     'wartosc2': ['parametr2', 'parametr3'],
#     'ls':{
#         '-l': 'wyswietlanie szczegolowe',
#         '-la': 'asd asd'
#     }
# }
