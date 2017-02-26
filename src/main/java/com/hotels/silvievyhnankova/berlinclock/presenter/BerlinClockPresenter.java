package com.hotels.silvievyhnankova.berlinclock.presenter;



public interface BerlinClockPresenter<T> {

    T display(int hrs, int min, int sec);

}
