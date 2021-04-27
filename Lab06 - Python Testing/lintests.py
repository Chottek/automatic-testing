import lab6 as manager
import unittest as tests


class Test(tests.TestCase):

    def test_right_param(self):
        man = manager.Chooser().choice("linux", "cd")
        self.assertFalse(man.__contains__("a right parameter"))

    def test_mkdir(self):
        man = manager.Chooser().choice("linux", "mkdir")
        self.assertEqual("", man)

    def test_sleep(self):
        man = manager.Chooser().choice("linux", "sleep --help")
        self.assertEqual("sleep --help>> display this help and exit", man)

    def test_wrong_sys(self):
        man = manager.Chooser().choice("linuks", "cd")
        self.assertTrue(man.__contains__("a right parameter"))
