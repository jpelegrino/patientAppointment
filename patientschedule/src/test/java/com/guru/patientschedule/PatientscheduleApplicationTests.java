package com.guru.patientschedule;

import com.guru.patientschedule.entities.Appointment;
import com.guru.patientschedule.entities.Doctor;
import com.guru.patientschedule.entities.Insurance;
import com.guru.patientschedule.entities.Patient;
import com.guru.patientschedule.repositories.AppointmentRepository;
import com.guru.patientschedule.repositories.DoctorRepository;
import com.guru.patientschedule.repositories.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientscheduleApplicationTests {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	public void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Jose");
		doctor.setLastName("Abreu");
		doctor.setSpeciality("General");

		doctorRepository.save(doctor);
	}

	@Test
	public void testCreatePatient() {
		Patient patient=new Patient();

		patient.setFirstName("Juan");
		patient.setLastName("Martinez");
		Insurance insurance = new Insurance();
		insurance.setCopay(BigDecimal.valueOf(80));
		insurance.setProviderName("Primera ARS Humano");
		patient.setInsurance(insurance);
		patient.setPhone("8095429632");
		Doctor doctor=doctorRepository.getOne(1);

		patient.setDoctors(Arrays.asList(doctor));

		patientRepository.save(patient);
	}

	@Test
//	@Transactional
	public void testCreateAppointment() {

		Appointment appointment = new Appointment();
		appointment.setStarted(true);
		appointment.setReason("I have a problem");
		appointment.setDoctor(doctorRepository.getOne(1));
		appointment.setPatient(patientRepository.getOne(1));
		Timestamp timestamp=new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(timestamp);
		appointmentRepository.save(appointment);

	}

}
