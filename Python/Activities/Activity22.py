import pytest

def test_sum():
    assert 10 + 5 == 15

def test_difference():
    assert 10 - 5 == 5

@pytest.mark.activity
def test_product():
    assert 10 * 5 == 50

@pytest.mark.activity
def test_quotient():
    assert 10 / 5 == 2