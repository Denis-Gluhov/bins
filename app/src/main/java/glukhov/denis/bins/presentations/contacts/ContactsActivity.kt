package glukhov.denis.bins.presentations.contacts

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import glukhov.denis.bins.App
import glukhov.denis.bins.R
import glukhov.denis.bins.presentations.base.BaseActivity
import kotlinx.android.synthetic.main.activity_contacts.*
import javax.inject.Inject

class ContactsActivity: BaseActivity(), ContactsView {

    @Inject lateinit var presenter: ContactsPresenter

    private lateinit var adapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        initUi()
    }

    override fun onCreateComponent() {
        App.getInstance().createContacts(this).inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.load()
    }

    private fun initUi() {
        adapter = ContactsAdapter(object: ContactsAdapter.Listener {
            override fun onClickItem(position: Int) {
                /***/
            }
        })
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvContacts.setHasFixedSize(true)
        rvContacts.adapter = adapter
        rlContacts.setOnRefreshListener { presenter.load() }
    }

    override fun onShowLoadData() {
        rlContacts.isRefreshing = true
    }

    override fun onHideLoadData() {
        rlContacts.isRefreshing = false
    }

    override fun onDataSet(data: List<Contact>) {
        adapter.setData(data)
    }

    override fun onShowMessage() {

    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}