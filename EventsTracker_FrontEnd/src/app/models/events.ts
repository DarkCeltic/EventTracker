import { Time } from '@angular/common';

export class Events {
    eventId: number;
    eventName: string;
    eventLocation: String;
    date: Date;
    time: string;
    constructor(eventId: number, eventName: string,
        eventLocation: String, date: Date, time: string) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.date = date;
        this.time = time;
    }
    
}