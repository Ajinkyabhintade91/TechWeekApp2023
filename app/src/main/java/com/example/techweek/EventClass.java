package com.example.techweek;

public class EventClass {
    private String eventTitle, eventTime, eventDescription, eventVenue, eventSpeakerBio, eventSpeaker;
    private int imageID;

    public EventClass() {
    }

    public EventClass(String eventTitle, String eventVenue, String eventTime, int imageID) {
        this.eventTitle = eventTitle;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.imageID = imageID;
        this.eventDescription = null;
        this.eventSpeakerBio = null;
        this.eventSpeaker = null;
    }

    public EventClass(String eventTitle, String eventVenue, String eventTime, String eventSpeaker, int imageID) {
        this.eventTitle = eventTitle;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.eventSpeaker = eventSpeaker;
        this.imageID = imageID;
        this.eventDescription = null;
        this.eventSpeakerBio = null;
    }

    public EventClass(String eventTitle, String eventVenue, String eventTime, String eventSpeaker, String eventDescription, String eventSpeakerBio, int imageID) {
        this.eventTitle = eventTitle;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.eventSpeaker = eventSpeaker;
        this.eventDescription = eventDescription;
        this.eventSpeakerBio = eventSpeakerBio;
        this.imageID = imageID;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventSpeakerBio() {
        return eventSpeakerBio;
    }

    public void setEventSpeakerBio(String eventSpeakerBio) {
        this.eventSpeakerBio = eventSpeakerBio;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getEventSpeaker() {
        return eventSpeaker;
    }

    public void setEventSpeaker(String eventSpeaker) {
        this.eventSpeaker = eventSpeaker;
    }
}
