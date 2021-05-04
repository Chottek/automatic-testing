import lab6 as manager
import unittest as tests
import pytest


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


class ParamLinPytest:

    @pytest.mark.parametrize(
        "a, b, expected",
        [
            pytest.param("linux", "cd", "Wrong argument!"),
            pytest.param("linux", "mkdir -m", "mkdir -m>> set file mode (as in chmod), not a=rwx - umask")
        ],
    )
    def test_sys_with_params(self, a, b, expected):
        man = manager.Chooser().choice(a, b)
        assert man == expected
