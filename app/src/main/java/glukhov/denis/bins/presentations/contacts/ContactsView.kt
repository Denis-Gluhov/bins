package glukhov.denis.bins.presentations.contacts

interface ContactsView {
    fun onShowLoadData()

    fun onHideLoadData()

    fun onDataSet(data: List<Contact>)

    fun onShowMessage()
}