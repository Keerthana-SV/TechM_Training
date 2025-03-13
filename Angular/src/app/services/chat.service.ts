import { Injectable, inject } from '@angular/core';
import { Firestore, collection, addDoc, query, orderBy, collectionData } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

interface ChatMessage {
  uid: string;
  displayName: string;
  text: string;
  timestamp: number;
}

@Injectable({ providedIn: 'root' })
export class ChatService {
  private firestore = inject(Firestore);
  private chatCollection = collection(this.firestore, 'messages');

  sendMessage(uid: string, displayName: string, text: string) {
    return addDoc(this.chatCollection, { uid, displayName, text, timestamp: Date.now() });
  }

  getMessages(): Observable<ChatMessage[]> {
    const q = query(this.chatCollection, orderBy('timestamp', 'asc'));
    return collectionData(q) as Observable<ChatMessage[]>;
  }
}
