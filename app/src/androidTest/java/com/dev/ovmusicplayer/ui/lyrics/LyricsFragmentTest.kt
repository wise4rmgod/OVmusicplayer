package com.dev.ovmusicplayer.ui.lyrics


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.ui.dashboard.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LyricsFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.WRITE_EXTERNAL_STORAGE"
        )

    @Test
    fun lyricsFragmentTest() {
        val materialTextView = onView(
            allOf(
                withId(R.id.item2), withText("Lyrics"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.FrameLayout")),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.item1), withText("Details"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Details")))

        val textView2 = onView(
            allOf(
                withId(R.id.item2), withText("Lyrics"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Lyrics")))

        val textView3 = onView(
            allOf(
                withId(R.id.item3), withText("Visualization"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Visualization")))

        val textView4 = onView(
            allOf(
                withId(R.id.textview_first), withText("Getting around the bowel"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Getting around the bowel")))

        val textView5 = onView(
            allOf(
                withId(R.id.textview_second),
                withText("Constellations | Mark thomas and Nina Jay | 2021"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Constellations | Mark thomas and Nina Jay | 2021")))

        val view = onView(
            allOf(
                withId(R.id.custom_lyric_view),
                withParent(
                    allOf(
                        withId(R.id.card_body),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        view.check(matches(isDisplayed()))

        val seekBar = onView(
            allOf(
                withId(R.id.ov_seekbar),
                withParent(
                    allOf(
                        withId(R.id.exopos),
                        withParent(withId(R.id.ov_buttons))
                    )
                ),
                isDisplayed()
            )
        )
        seekBar.check(matches(isDisplayed()))

        val imageView = onView(
            allOf(
                withId(R.id.ov_skipback),
                withParent(withParent(withId(R.id.ov_buttons))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val imageView2 = onView(
            allOf(
                withId(R.id.ov_rewind),
                withParent(withParent(withId(R.id.ov_buttons))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val imageView3 = onView(
            allOf(
                withId(R.id.ov_play),
                withParent(withParent(withId(R.id.ov_buttons))),
                isDisplayed()
            )
        )
        imageView3.check(matches(isDisplayed()))

        val imageView4 = onView(
            allOf(
                withId(R.id.ov_forward),
                withParent(withParent(withId(R.id.ov_buttons))),
                isDisplayed()
            )
        )
        imageView4.check(matches(isDisplayed()))

        val imageView5 = onView(
            allOf(
                withId(R.id.ov_skipnext),
                withParent(withParent(withId(R.id.ov_buttons))),
                isDisplayed()
            )
        )
        imageView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withId(R.id.upnext_text), withText("Up Next: All the way up"),
                withParent(
                    allOf(
                        withId(R.id.upnext_menubottom),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("Up Next: All the way up")))

        val imageView6 = onView(
            allOf(
                withId(R.id.upnext_btn),
                withParent(
                    allOf(
                        withId(R.id.upnext_menubottom),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView6.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
