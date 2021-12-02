package com.example.pet_out;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.pet_out.model.Step;
import com.example.pet_out.model.StepDAO;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.pet_out", appContext.getPackageName());
    }
    public Step step;
    public Context context;

    @Before
    public void setup(){
        context=InstrumentationRegistry.getInstrumentation().getContext();
        step= new Step(R.raw.care,context.getResources().getString(R.string.label_discover_pet),
                context.getResources().getString(R.string.label_discover_pet));
    }

    @After
     public void finish(){

    }
    @Test
    public void insertStep(){
        long response = StepDAO.insert(step,context);// - 1 X||>=0
        assertTrue(response >= 0);

    }
    @Test
    public void validaContextNull(){
        assertNotNull(context);
    }

    @Test
    public void insertErrorStep(){
        step.setId(1);
        long response=StepDAO.insertwithId(step, context);//-1 X || >=0
        assertFalse(response >= 0);
    }


}