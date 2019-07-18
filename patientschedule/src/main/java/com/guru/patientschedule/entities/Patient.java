package com.guru.patientschedule.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Patient implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @Column(name = "first_name")
   private String firstName;
    @Column(name = "last_name")
   private String lastName;
   private String phone;
   @Embedded
   private Insurance insurance;

   @OneToMany(mappedBy = "patient")
   private Set<Appointment> appointments;


   @ManyToMany
   @JoinTable(name = "patients_doctors",
           joinColumns ={@JoinColumn(name = "patient_id", referencedColumnName = "id")},
           inverseJoinColumns = {@JoinColumn(name = "doctor_id", referencedColumnName = "id")})
   private List<Doctor> doctors;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
