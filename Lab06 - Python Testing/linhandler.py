class LinHandler:

    def handle(self, arg):
        args = arg.split(" ")
        return arg + ">> " + self.DICTIONARY[args[0]].get(args[1]) if args[0] in self.DICTIONARY \
            else "Wrong argument!"

    DICTIONARY = {
        'whoami': 'Actually I am a script ( ͡~ ͜ʖ ͡°) [IN LINUX]',
        'rm': {
            '-f': 'ignore nonexistent files and arguments, never prompt',
            '-i': 'prompt before every removal',
            '-r': 'remove directories and their contents recursively'
        },
        'mkdir': {
            '-m': 'set file mode (as in chmod), not a=rwx - umask',
            '-p': 'no error if existing, make parent directories as needed',
            '-v': 'print a message for each created directory'
        },
        'ls': {
            '-a': 'do not ignore entries starting with .',
            '-b': 'print C-style escapes for nongraphic characters',
            '-d': 'list directories themselves, not their contents',
        },
        'sleep': {
            '--help': 'display this help and exit',
            '--version': 'output version information and exit'
        },
        'kill': {
            '-s': 'Specify the signal to be sent. The signal can be specified by using name or number. The '
                  'behavior of signals is explained in signal(7) manual page.',
            '-l': 'List signal names. This option has optional argument, which will convert signal number to '
                  'signal name, or other way round.',
            '-L': 'List signal names in a nice table.'
        }
    }
