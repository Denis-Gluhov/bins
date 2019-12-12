package glukhov.denis.bins.presentations.contacts

import dagger.Subcomponent

@ContactsScreen
@Subcomponent(modules = [ContactsModule::class])
interface ContactsComponent {

    fun inject(activity: ContactsActivity)

}