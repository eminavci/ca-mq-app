export interface RestResponse {
    message:string, 
    result: boolean,
    data: any;

}


export class QMMessage {
    id: number;
    message: string;
    messageId: string;
    date: Date;

    constructor(){
        this.id = -1;
        this.message = '';
        this.messageId = '';
        this.date = new Date();
    }
}