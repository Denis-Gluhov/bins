package glukhov.denis.bins.di

import dagger.Component
import glukhov.denis.bins.presentations.contacts.ContactsComponent
import glukhov.denis.bins.presentations.contacts.ContactsModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun createContactsComponent(module: ContactsModule): ContactsComponent

}