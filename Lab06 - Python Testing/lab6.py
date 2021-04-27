import winhandler as win
import linhandler as linux
import platform
import sys


class Chooser:

    def choice(self, system, arg):
        choice = system.upper()
        if (choice != "WINDOWS") and (choice.upper() != "LINUX") and (choice.upper() != "DARWIN"):
            return system + " isn't a right parameter (windows or linux is suitable)"

        return win.WinHandler().handle(arg) if system.upper() == "WINDOWS" \
            else linux.LinHandler().handle(arg)


# print(Chooser().choice(platform.system(), sys.argv[1]))
