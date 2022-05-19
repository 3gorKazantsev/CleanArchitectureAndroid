package org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs

import android.content.Context
import org.egorkazantsev.cleanarchitecture.data.model.UserD
import org.egorkazantsev.cleanarchitecture.data.storage.UserStorage

private const val SHARED_PREFS_NAME =
    "org.egorkazantsev.cleanarchitecture.data.repository.SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME =
    "org.egorkazantsev.cleanarchitecture.data.repository.KEY_FIRST_NAME"
private const val KEY_LAST_NAME =
    "org.egorkazantsev.cleanarchitecture.data.repository.KEY_LAST_NAME"
const val DEFAULT_FIRST_NAME = "Default first name"
const val DEFAULT_LAST_NAME = "Default last name"

class UserSharedPrefs(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUser(user: UserD): Boolean {
        with(sharedPreferences.edit()) {
            putString(KEY_FIRST_NAME, user.firstName)
            putString(KEY_LAST_NAME, user.lastName)
            apply()
        }
        return true
    }

    override fun getUser(): UserD {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return UserD(firstName, lastName)
    }
}