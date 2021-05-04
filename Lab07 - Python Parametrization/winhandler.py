class WinHandler:

    def handle(self, arg):
        args = arg.split(" ")
        return arg + ">> " + self.DICTIONARY[args[0]].get(args[1]) if args[0] in self.DICTIONARY \
            else "Wrong argument!"

    DICTIONARY = {
        'dir': {
            '-l': 'wyswietlanie szczegolowe',
            '-la': 'asd asd'
        },
        'echo': {
            'on': 'Turns on the command echoing feature. It\'s on by default.',
            'off': 'Turns off the command echoing feature. It is on by default.'
        },
        'color': {
            '<b>': 'Specifies the background color.',
            '<f>': 'Specifies the foreground color.'
        }
    }
