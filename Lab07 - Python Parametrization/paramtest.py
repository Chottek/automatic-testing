import pytest


def checkRange(par1, par2, par3):
    if not type(par1) == int and not type(par2) == int and not type(par3) == int:
        return False
    return -7 <= par1 <= 7 and -7 <= par2 <= 7 and -7 <= par3 <= 7


data = [
    (-7, 4, 7),
    (10, 1, 4),
    (1, 2, 3),
]
data2 = [
    (-5, 4, 10),
    (-10, -5, 1),
    (1, 2, "three"),
    (5, 0, 5),
    (True, 7, -7),
]


@pytest.mark.parametrize("par1, par2, par3", data)
def test_interval_true(par1, par2, par3):
    assert checkRange(par1, par2, par3) is True


@pytest.mark.parametrize("par1, par2, par3", data2)
def test_interval_false(par1, par2, par3):
    assert not checkRange(par1, par2, par3) is True
