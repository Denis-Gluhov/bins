package glukhov.denis.bins.presentations.contacts

import dagger.Module
import dagger.Provides
import glukhov.denis.bins.data.network.Api
import glukhov.denis.bins.domain.ContactsUseCase

@Module
class ContactsModule(
    private val view: ContactsView
) {

    @ContactsScreen
    @Provides
    fun providePresenter(api: Api): ContactsPresenter {
        val contactsUseCase = ContactsUseCase(api)
        return ContactsPresenter(view, contactsUseCase)
    }

}