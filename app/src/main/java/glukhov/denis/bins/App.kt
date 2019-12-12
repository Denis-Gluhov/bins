package glukhov.denis.bins

import android.app.Application
import glukhov.denis.bins.di.AppComponent
import glukhov.denis.bins.di.DaggerAppComponent
import glukhov.denis.bins.di.NetworkModule
import glukhov.denis.bins.presentations.contacts.ContactsActivity
import glukhov.denis.bins.presentations.contacts.ContactsComponent
import glukhov.denis.bins.presentations.contacts.ContactsModule

class App: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }

    fun createContacts(activity: ContactsActivity): ContactsComponent {
        return appComponent.createContactsComponent(ContactsModule(activity))
    }

    companion object {
        private lateinit var instance: App

        fun getInstance(): App {
            return instance
        }
    }

}