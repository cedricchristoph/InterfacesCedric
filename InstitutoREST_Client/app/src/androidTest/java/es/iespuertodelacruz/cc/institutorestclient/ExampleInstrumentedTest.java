package es.iespuertodelacruz.cc.institutorestclient;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.database.AlumnoHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.AlumnoMatriculaHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.AsignaturaHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.MatriculaHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Asignatura;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AsignaturaRepository;

/**
 * Instrumented test, which will execute on an Android device.
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("es.iespuertodelacruz.cc.institutorestclient", appContext.getPackageName());
    }

    @Test
    public void testHelpers() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AsignaturaRepository repo = new AsignaturaRepository(appContext);
        Optional<List<Asignatura>> optional = repo.selectAll();
        optional.get().forEach(a -> Log.d("ENTITY", a.toString()));
    }
}