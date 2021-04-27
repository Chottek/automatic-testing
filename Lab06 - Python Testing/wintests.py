import lab6 as manager
import unittest as tests


class Test(tests.TestCase):

    def test_cd(self):
        man = manager.Chooser().choice("windows", "cd")
        self.assertEqual(man, "Wrong argument!")

    def test_inner_dir(self):
        man = manager.Chooser().choice("windows", "dir -l")
        self.assertIsNotNone(man)

    def test_color(self):
        man = manager.Chooser().choice("windows", "color <b>")
        self.assertEqual(man, "color <b>>> Specifies the background color.")




